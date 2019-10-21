package com.example.dramaclubpointsapp;

import android.graphics.Point;

public class PointSubmission {

    private String time;
    private String firstName, lastName;
    private String nameOfProduction;
    private String role;
    private String memes;

    public PointSubmission(String time, String firstName, String lastName, String prod, String role, String memes){
        this.time = time;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nameOfProduction = prod;
        this.role = role;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNameOfProduction() {
        return nameOfProduction;
    }

    public void setNameOfProduction(String nameOfProduction) {
        this.nameOfProduction = nameOfProduction;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMemes() {
        return memes;
    }

    public void setMemes(String memes) {
        this.memes = memes;
    }
}
