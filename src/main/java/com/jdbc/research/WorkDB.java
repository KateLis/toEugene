package com.jdbc.research;

import java.sql.*;
import java.util.List;

public class WorkDB {
    private Connection connection; //можно connection = Util.getConnection();

    WorkDB() {
        this.connection = Util.getConnection();
    }

    public void insertIntoTable() {
        String sqlInsert = "INSERT INTO test (Name, Age) VALUES (?, ?)";
        try {
            // Statement statement = connection.createStatement();
            //  statement.execute("INSERT INTO test (Name, Age) VALUES ('Ivan', 44)");
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, "Lena");
            preparedStatement.setInt(2, 32);
            preparedStatement.execute();
            //   statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUserById(String id){
        String sqlUpdate = "UPDATE test SET name='Renat', age ='56' WHERE id=?" ;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUserByIdWithParam(String id, User user){ //офигеть, какие крутые штуки сама пишу!
        String sqlUpdate = "UPDATE test SET name=?, age =? WHERE id=?" ;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, user.name);
            preparedStatement.setInt(2, user.age);
            preparedStatement.setString(3,id);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertIntoTableAll(List<User> list) {
        String sqlInsert = "INSERT INTO test (Name, Age) VALUES (?, ?)";
        try {
            for (User user : list) {
                PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);

                preparedStatement.setString(1, user.getName());
                preparedStatement.setInt(2, user.getAge());
                preparedStatement.execute();
            }
            //   statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void getAllUsers() throws SQLException {
        String sqlGetAll = "SELECT * FROM test";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlGetAll);
        while (resultSet.next()){
            User user = new User(resultSet.getString("Name"), resultSet.getInt("Age"));
//            user.setName(resultSet.getString("Name"));
//            user.setAge(resultSet.getInt("Age")); //НЕ СЛИШКОМ ЛИ много и сет и гет?? так делают, если много полей
            System.out.println(user);
//            System.out.println(resultSet.getString("Name"));
//            System.out.println(resultSet.getInt("Age"));
        }
    }
    public void addColumn(){
        String sqlAddColumn = "ALTER TABLE test ADD COLUMN Id VARCHAR (50)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlAddColumn);
           // preparedStatement.setString(1, s); почему нельзя с параметром String s и вопросом??
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setId(){
        String sqlSetId = "UPDATE test SET id=1 WHERE Name = 'Lena'";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlSetId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteRows(String s){
        String sqlDelete = "DELETE FROM test WHERE Name=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlDelete);
            preparedStatement.setString(1,s);
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void primaryKey() {
        String sqlPrima = "ALTER TABLE test ADD PRIMARY KEY (ID)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlPrima);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void getUserById(String id){
        String sqlGetUser = "SELECT Name FROM test WHERE Id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlGetUser);
            preparedStatement.setString(1,id);
            preparedStatement.execute();
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("Name");
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void changeColumnType(){
        String sqlFromCharToInt = "ALTER TABLE test ALTER COLUMN Id TYPE numeric(10,2) USING age::numeric(10,2)";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sqlFromCharToInt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

