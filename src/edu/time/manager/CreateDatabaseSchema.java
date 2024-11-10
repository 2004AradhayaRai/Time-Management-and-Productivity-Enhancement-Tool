package edu.time.manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDatabaseSchema {

    // Database URL for creating a database (do not include the database name here)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "helloworld@1234";

    // Database name you want to create
    private static final String DATABASE_NAME = "TimeManagement";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL server (without specifying a database)
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            statement = connection.createStatement();

            // SQL statement to create a database
            String createDatabaseSQL = "CREATE DATABASE IF NOT EXISTS " + DATABASE_NAME;

            // Execute the statement
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("Database '" + DATABASE_NAME + "' created successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to create database.");
            e.printStackTrace();
        } finally {
            // Clean up
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

