package com.fitnessapp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        WorkoutDAO workoutDAO = new WorkoutDAO();

        System.out.println("=== Fitness App ===");

        // Create user
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        int userId = userDAO.createUser(username);

        if (userId == -1) {
            System.out.println("Failed to create user.");
            return;
        }

        System.out.println("User ID: " + userId);

        while (true) {
            System.out.println("\n1. Add workout");
            System.out.println("2. View workouts");
            System.out.println("3. Delete workout");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Workout name: ");
                String name = scanner.nextLine();

                System.out.print("Duration: ");
                int duration = scanner.nextInt();

                System.out.print("Calories: ");
                int calories = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Type: ");
                String type = scanner.nextLine();

                workoutDAO.addWorkout(userId, name, duration, calories, type);

            } else if (choice == 2) {
                System.out.println("\nYour workouts:");
                workoutDAO.getUserWorkouts(userId).forEach(System.out::println);

            } else if (choice == 3) {
                System.out.print("Enter workout ID to delete: ");
                int workoutId = scanner.nextInt();
                scanner.nextLine();
                workoutDAO.deleteWorkout(workoutId);

            } else {
                break;
            }
        }

        scanner.close();
    }
}