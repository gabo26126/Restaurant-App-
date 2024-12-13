package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class MainCourse {
    @SerializedName("mainCourseID")
    private int mainCourseID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
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
