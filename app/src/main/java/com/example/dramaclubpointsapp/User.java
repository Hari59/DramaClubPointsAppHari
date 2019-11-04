package com.example.dramaclubpointsapp;

public class User {

    public String username;
    public int points;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, int points) {
        this.username = username;
        this.points = points;
    }

    public int getPoints() {
        return points;
    }
}

