package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private Connection conn;
    private static DbManager dbManagerInstance;
    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password"); // kodilla_password
        System.out.println("In DbManager before setting conn------------------");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
        //System.out.println("In DbManager - Constructor: " + conn.toString());
    }
    public static DbManager getInstance() throws SQLException{
        if(dbManagerInstance == null){
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }
    public Connection getConnection() {
        return conn;
    }
}
