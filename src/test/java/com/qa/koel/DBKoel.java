package com.qa.koel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBKoel {
    public static void main(String[] args) {
        String serverAddress = "104.237.13.60";
        int portNumber = 3306;
        String databaseName = "dbkoel";
        String username = "dbuser20";
        String password = "pa$$20";

        try {
            // Register the JDBC driver (MariaDB in this case)
            Class.forName("org.mariadb.jdbc.Driver");

            // Create the database URL
            String url = "jdbc:mariadb://" + serverAddress + ":" + portNumber + "/" + databaseName;

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Print a success message
            System.out.println("Connected to the MariaDB database!");

            // Close the connection
            connection.close();
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading JDBC driver: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
        }
    }
}
