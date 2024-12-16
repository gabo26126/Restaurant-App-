package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Starter starter = (Starter) o;
        return starterID == starter.starterID && Double.compare(price, starter.price) == 0 && Objects.equals(name, starter.name) && Objects.equals(description, starter.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(starterID, name, description, price);
    }
}
