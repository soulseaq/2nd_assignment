package com.fitnessapp;

public class TestDriver {
    public static void main(String[] args) {
        System.out.println("Testing PostgreSQL driver...");

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("✅ Driver FOUND!");
        } catch (ClassNotFoundException e) {
            System.err.println("❌ Driver NOT FOUND!");
            System.err.println("Add JAR to: File → Project Structure → Libraries");
        }
    }
}
