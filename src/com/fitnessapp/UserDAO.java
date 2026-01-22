package com.fitnessapp;

import java.sql.*;

public class UserDAO {

    public int createUser(String username) {
        String sql = "INSERT INTO app_user (username) VALUES (?) RETURNING id";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                System.out.println("✅ User created with ID: " + id);
                return id;
            }

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        return -1;
    }
}