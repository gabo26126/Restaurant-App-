package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class Starter extends MenuItem{
    @SerializedName("starterID")
    private int starterID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;

    public Starter(int starterID, String name, String description, double price) {
        this.starterID = starterID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getID() {
        return starterID;
    }

    @Override
    public void setID(Integer ID) {
        this.starterID = ID;
    }

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
