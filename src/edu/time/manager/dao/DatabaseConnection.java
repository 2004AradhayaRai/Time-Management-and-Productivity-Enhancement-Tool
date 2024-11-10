package edu.time.manager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/EduTimeManager?useSSL=false&serverTimezone=UTC";
    private static final String DB_USER = "root";         // Replace with your MySQL username
    private static final String DB_PASSWORD = "rootpassword"; // Replace with your MySQL password

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    /**
     * Establishes and returns a connection to the MySQL database.
     *
     * @return Connection object
     * @throws SQLException if a database access error occurs
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }
}

