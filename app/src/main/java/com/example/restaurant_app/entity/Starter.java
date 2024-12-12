package com.example.restaurant_app.entity;

public class Starter {
    private int starterID;
    private String name;
    private String description;
    private double price;

    public int getStarterID() {
        return starterID;
    }

    public void setStarterID(int starterID) {
        this.starterID = starterID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
