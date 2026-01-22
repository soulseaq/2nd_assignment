package com.fitnessapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private List<WorkoutPlan> workouts = new ArrayList<>();

    // Constructors
    public User() {}

    public User(int id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    // Business logic methods
    public void addWorkout(WorkoutPlan workout) {
        workouts.add(workout);
        System.out.println("➕ Added workout: " + workout.getName());
    }

    public void showWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("📭 No workouts recorded yet.");
            return;
        }

        System.out.println("📋 Workout History for " + username + ":");
        for (WorkoutPlan w : workouts) {
            System.out.println("   " + w);
        }
    }

    public int getTotalCaloriesBurned() {
        int total = 0;
        for (WorkoutPlan w : workouts) {
            total += w.calculateCalories();
        }
        System.out.println("🔥 Total calories burned: " + total);
        return total;
    }

    public void filterByDuration(int minDuration) {
        boolean found = false;
        System.out.println("⏰ Workouts longer than " + minDuration + " minutes:");
        for (WorkoutPlan w : workouts) {
            if (w.getDuration() >= minDuration) {
                System.out.println("   " + w);
                found = true;
            }
        }
        if (!found) {
            System.out.println("   No workouts match the criteria.");
        }
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<WorkoutPlan> getWorkouts() { return workouts; }
    public void setWorkouts(List<WorkoutPlan> workouts) { this.workouts = workouts; }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", email=" + email +
                ", workouts=" + workouts.size() + "]";
    }
}