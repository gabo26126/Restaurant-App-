package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class Dessert {
    @SerializedName("dessertID")
    private Integer dessertID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;

    public Dessert(Integer dessertID, String name, String description, double price) {
        this.dessertID = dessertID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Integer getDessertID() {
        return dessertID;
    }

    public void setDessertID(Integer dessertID) {
        this.dessertID = dessertID;
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
