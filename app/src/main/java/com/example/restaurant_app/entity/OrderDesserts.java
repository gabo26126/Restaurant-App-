package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

public class OrderDesserts {
    @SerializedName("dessert")
    private Dessert dessert;
    @SerializedName("amount")
    private int amount;
    @SerializedName("orderDessertID")
    private int orderDessertID;
    @SerializedName("orderID")
    private int orderID;
    @SerializedName("status")
    private boolean status;

    public OrderDesserts(Dessert dessert, int amount, int orderDessertID, int orderID, boolean status) {
        this.dessert = dessert;
        this.amount = amount;
        this.orderDessertID = orderDessertID;
        this.orderID = orderID;
        this.status = status;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderDessertID() {
        return orderDessertID;
    }

    public void setOrderDessertID(int orderDessertID) {
        this.orderDessertID = orderDessertID;
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
