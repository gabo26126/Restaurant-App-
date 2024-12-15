package com.example.restaurant_app.entity;

public abstract class MenuItem {
    public abstract Integer getID();

    public abstract void setID(Integer ID);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract String getDescription();

    public abstract void setDescription(String description);

    public abstract double getPrice();

    public abstract void setPrice(double price);
}
