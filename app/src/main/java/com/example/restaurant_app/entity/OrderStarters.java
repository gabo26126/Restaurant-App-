package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class OrderStarters {
    @SerializedName("starter")
    private Starter starter;
    @SerializedName("amount")
    private int amount;
    @SerializedName("orderStarterID")
    private int orderStarterID;
    @SerializedName("orderID")
    private int orderID;
    @SerializedName("status")
    private boolean status;

    public Starter getStarter() {
        return starter;
    }

    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderStarterID() {
        return orderStarterID;
    }

    public void setOrderStarterID(int orderStarterID) {
        this.orderStarterID = orderStarterID;
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
