package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Order {
    @SerializedName("orderStarters")
    private List<OrderStarters> orderStarters;
    @SerializedName("orderMainCourses")
    private List<OrderMainCourses> orderMainCourses;
    @SerializedName("orderDesserts")
    private List<OrderDesserts> orderDesserts;
    @SerializedName("orderDrinks")
    private List<OrderDrinks> orderDrinks;
    @SerializedName("orderID")
    private Integer orderID;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("notes")
    private String notes;
    @SerializedName("tablenumber")
    private Integer tableNumber;

    public Order(List<OrderStarters> orderStarters, List<OrderMainCourses> orderMainCourses, List<OrderDesserts> orderDesserts, List<OrderDrinks> orderDrinks, Integer orderID, String createdAt, String notes, Integer tableNumber) {
        this.orderStarters = orderStarters;
        this.orderMainCourses = orderMainCourses;
        this.orderDesserts = orderDesserts;
        this.orderDrinks = orderDrinks;
        this.orderID = orderID;
        this.createdAt = createdAt;
        this.notes = notes;
        this.tableNumber = tableNumber;
    }

    public List<OrderStarters> getOrderStarters() {
        return orderStarters;
    }

    public void setOrderStarters(List<OrderStarters> orderStarters) {
        this.orderStarters = orderStarters;
    }

    public List<OrderMainCourses> getOrderMainCourses() {
        return orderMainCourses;
    }

    public void setOrderMainCourses(List<OrderMainCourses> orderMainCourses) {
        this.orderMainCourses = orderMainCourses;
    }

    public List<OrderDesserts> getOrderDesserts() {
        return orderDesserts;
    }

    public void setOrderDesserts(List<OrderDesserts> orderDesserts) {
        this.orderDesserts = orderDesserts;
    }

    public List<OrderDrinks> getOrderDrinks() {
        return orderDrinks;
    }

    public void setOrderDrinks(List<OrderDrinks> orderDrinks) {
        this.orderDrinks = orderDrinks;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(Integer tableNumber) {
        this.tableNumber = tableNumber;
    }
}
