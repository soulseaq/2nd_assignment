package com.fitnessapp;

public class WorkoutPlan {
    protected int id;
    protected int userId;
    protected String name;
    protected int duration;
    protected int calories;
    protected String workoutType;

    // Constructors
    public WorkoutPlan() {}

    public WorkoutPlan(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public WorkoutPlan(int id, int userId, String name, int duration,
                       int calories, String workoutType) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.duration = duration;
        this.calories = calories;
        this.workoutType = workoutType;
    }

    // Polymorphic method - can be overridden by child classes
    public int calculateCalories() {
        return duration * 5; // Base formula
    }

    public String getType() {
        return "General Workout";
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public int getCalories() { return calories; }
    public void setCalories(int calories) { this.calories = calories; }

    public String getWorkoutType() { return workoutType; }
    public void setWorkoutType(String workoutType) { this.workoutType = workoutType; }

    @Override
    public String toString() {
        return String.format("%s | %s | Duration: %d min | Calories: %d | Type: %s",
                getType(), name, duration, calculateCalories(), workoutType);
    }
}