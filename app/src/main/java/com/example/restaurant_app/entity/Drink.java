package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class Drink  extends MenuItem{
    @SerializedName("drinkID")
    private int drinkID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;

    public Drink(int drinkID, String name, String description, double price) {
        this.drinkID = drinkID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Override
    public Integer getID() {
        return drinkID;
    }

    @Override
    public void setID(Integer ID) {
        this.drinkID = ID;
    }

    public int getDrinkID() {
        return drinkID;
    }

    public void setDrinkID(int drinkID) {
        this.drinkID = drinkID;
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
