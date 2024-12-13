package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class Starter {
    @SerializedName("starterID")
    private int starterID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
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
