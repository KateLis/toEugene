package com.jdbc.research;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Util {
    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null){
            try {
                connection = DriverManager.getConnection("jdbc:postgresql://localhost/test", "postgres", "Serverg0d!");
            } catch (SQLException throwables) {
               System.out.println("Connection exception.");
            }
        }
        return connection;
    }
public void deleteTable(String s){
    try {
        Statement statement3 = getConnection().createStatement();
        String sql = "DROP TABLE " + s;
        statement3.execute(sql);
        System.out.println("Table is dropped...");
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}

}
