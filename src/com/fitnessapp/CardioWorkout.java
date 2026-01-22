package com.fitnessapp;

public class CardioWorkout extends WorkoutPlan {
    private int intensity; // 1 (low) – 3 (high)

    public CardioWorkout(String name, int duration, int intensity) {
        super(name, duration);
        this.intensity = intensity;
        this.workoutType = "Cardio";
    }

    public CardioWorkout(int id, int userId, String name, int duration,
                         int calories, int intensity) {
        super(id, userId, name, duration, calories, "Cardio");
        this.intensity = intensity;
    }

    // Override parent method - polymorphism!
    @Override
    public int calculateCalories() {
        return duration * (5 + intensity * 2); // Cardio-specific formula
    }

    @Override
    public String getType() {
        return "Cardio Workout";
    }

    // Getter and Setter
    public int getIntensity() { return intensity; }
    public void setIntensity(int intensity) { this.intensity = intensity; }

    @Override
    public String toString() {
        return String.format("%s | %s | Duration: %d min | Intensity: %d | Calories: %d",
                getType(), name, duration, intensity, calculateCalories());
    }
}