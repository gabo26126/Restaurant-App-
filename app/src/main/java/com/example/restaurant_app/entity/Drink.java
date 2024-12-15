package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Drink {
    @SerializedName("dessertID")
    private int dessertID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;

    public int getDessertID() {
        return dessertID;
    }

    public void setDessertID(int dessertID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return dessertID == drink.dessertID && Double.compare(price, drink.price) == 0 && Objects.equals(name, drink.name) && Objects.equals(description, drink.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dessertID, name, description, price);
    }
}
