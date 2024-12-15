package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class OrderMainCourses {
    @SerializedName("mainCourse")
    private MainCourse mainCourse;
    @SerializedName("amount")
    private int amount;
    @SerializedName("orderMainCourseID")
    private int orderMainCourseID;
    @SerializedName("orderID")
    private int orderID;
    @SerializedName("status")
    private boolean status;

    public MainCourse getMainCourse() {
        return mainCourse;
    }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderMainCourseID() {
        return orderMainCourseID;
    }

    public void setOrderMainCourseID(int orderMainCourseID) {
        this.orderMainCourseID = orderMainCourseID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMainCourses that = (OrderMainCourses) o;
        return amount == that.amount && orderMainCourseID == that.orderMainCourseID && orderID == that.orderID && status == that.status && Objects.equals(mainCourse, that.mainCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mainCourse, amount, orderMainCourseID, orderID, status);
    }
}
