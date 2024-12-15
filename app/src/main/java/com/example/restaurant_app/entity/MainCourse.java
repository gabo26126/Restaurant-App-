package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class MainCourse {
    @SerializedName("mainCourseID")
    private int mainCourseID;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private double price;

    public int getMainCourseIDID() {
        return mainCourseID;
    }

    public void setMainCourseIDID(int dessertID) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MainCourse that = (MainCourse) o;
        return mainCourseID == that.mainCourseID && Double.compare(price, that.price) == 0 && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainCourseID, name, description, price);
    }
}
