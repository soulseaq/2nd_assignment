package com.fitnessapp;

import java.sql.*;

public class SimpleDB {
    public static void main(String[] args) {
        System.out.println("Testing PostgreSQL connection...");

        // Try ALL combinations until one works
        String[][] configs = {
                {"localhost:5432", "postgres", "postgres", "fitness_db"},
                {"localhost:5432", "postgres", "", "postgres"},
                {"127.0.0.1:5432", "postgres", "postgres", "postgres"},
                {"localhost:5433", "postgres", "postgres", "postgres"},
        };

        for (String[] config : configs) {
            String host = config[0];
            String user = config[1];
            String pass = config[2];
            String db = config[3];

            String url = "jdbc:postgresql://" + host + "/" + db;

            System.out.println("\nTrying: " + url + " (user: " + user + ")");

            try {
                Connection conn = DriverManager.getConnection(url, user, pass);
                System.out.println("🎉 SUCCESS! Connected to: " + db);

                // Show databases
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT datname FROM pg_database");
                System.out.println("Available databases:");
                while (rs.next()) {
                    System.out.println("  - " + rs.getString(1));
                }

                conn.close();
                break; // Stop on first success

            } catch (SQLException e) {
                System.out.println("Failed: " + e.getMessage());
            }
        }
    }
}