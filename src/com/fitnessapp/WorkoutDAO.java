package com.fitnessapp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDAO {

    // SIMPLE: Add workout (no intensity!)
    public void addWorkout(int userId, String name, int duration, int calories, String type) {
        String sql = "INSERT INTO workout_plan (user_id, name, duration, calories, workout_type) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setString(2, name);
            ps.setInt(3, duration);
            ps.setInt(4, calories);
            ps.setString(5, type);

            ps.executeUpdate();
            System.out.println("✅ Workout added!");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    // SIMPLE: Get workouts
    public List<String> getUserWorkouts(int userId) {
        List<String> workouts = new ArrayList<>();

        String sql = "SELECT name, duration, calories, workout_type FROM workout_plan WHERE user_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String workout = rs.getString("name") + " | " +
                        rs.getInt("duration") + " min | " +
                        rs.getInt("calories") + " cal | " +
                        rs.getString("workout_type");
                workouts.add(workout);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return workouts;
    }

    // SIMPLE: Delete workout
    public void deleteWorkout(int workoutId) {
        String sql = "DELETE FROM workout_plan WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, workoutId);
            ps.executeUpdate();
            System.out.println("✅ Workout deleted!");

        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}