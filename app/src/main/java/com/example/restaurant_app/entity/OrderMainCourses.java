package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

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

    public OrderMainCourses(MainCourse mainCourse, int amount, int orderMainCourseID, int orderID, boolean status) {
        this.mainCourse = mainCourse;
        this.amount = amount;
        this.orderMainCourseID = orderMainCourseID;
        this.orderID = orderID;
        this.status = status;
    }

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
}
