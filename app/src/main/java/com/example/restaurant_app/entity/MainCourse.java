package com.example.restaurant_app.entity;

public class MainCourse {
    private int mainCourseID;
    private String name;
    private String description;
    private double price;

    public int getDessertID() {
        return mainCourseID;
    }

    public void setDessertID(int dessertID) {
        this.mainCourseID = dessertID;
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
