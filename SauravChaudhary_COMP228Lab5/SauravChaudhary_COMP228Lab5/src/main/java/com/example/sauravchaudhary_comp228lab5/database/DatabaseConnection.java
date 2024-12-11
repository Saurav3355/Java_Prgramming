package com.example.sauravchaudhary_comp228lab5.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:oracle:thin:@oracle1.centennialcollege.ca:1521:SQLD"; // Update with your database URL
    private static final String USER = "COMP228_F24_soh_38";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
