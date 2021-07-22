package com.jdbc.research;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static com.jdbc.research.Util.getConnection;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = Util.getConnection();
        //            Statement statement = connection.createStatement();
//            statement.executeQuery("SELECT * FROM users;");
//        CrTable crTable = new CrTable();
//        crTable.createTable();
//         Util util1 = new Util();
//         util1.deleteTable("public.spbusers7");
         WorkDB wb = new WorkDB();
       //  wb.insertIntoTable();
//         User user1 = new User("Jack", 34);
//        User user2 = new User("Jhon", 98);
//        User user3 = new User("Harry", 14);
//        List<User> mylist = Arrays.asList(user1, user2, user3);
//        wb.insertIntoTableAll(mylist);
    //    wb.getAllUsers();
        //wb.addColumn();
       // wb.setId();
      //  wb.primaryKey();
      //  wb.deleteRows("Harry");
      //  wb.getUserById("2");
        wb.changeColumnType();
       //   wb.updateUserById("2");
       //   wb.updateUserByIdWithParam("1", User.user1);

}
    //static class CrTable {
        public void createTable() {
            try {
                Statement statement2 = getConnection().createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS public.test" +
                        " (name VARCHAR(50), " +
                        " age INTEGER )";
//                String queryCreateTable = "CREATE TABLE IF NOT EXISTS public.users1 " +
//                        " (id SERIAL NOT NULL, " +
//                        "name VARCHAR(255), " +
//                        "lastname VARCHAR(255), " +
//                        "age INTEGER," +
//                        "PRIMARY KEY(id) )";
                statement2.execute(sql);
                statement2.close();
                System.out.println("Table successfully created...");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

