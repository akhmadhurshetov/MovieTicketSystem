package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database URL, username, and password should be configured here
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/movieticketsystem";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    static {
        try {
            // Ensuring the JDBC driver is loaded
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
    }
}