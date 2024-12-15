package com.example.restaurant_app.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class OrderDrinks {
    @SerializedName("drink")
    private Drink drink;
    @SerializedName("amount")
    private int amount;
    @SerializedName("orderDrinkID")
    private int orderDrinkID;
    @SerializedName("orderID")
    private int orderID;
    @SerializedName("status")
    private boolean status;

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderDrinkID() {
        return orderDrinkID;
    }

    public void setOrderDrinkID(int orderDrinkID) {
        this.orderDrinkID = orderDrinkID;
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
        OrderDrinks that = (OrderDrinks) o;
        return amount == that.amount && orderDrinkID == that.orderDrinkID && orderID == that.orderID && status == that.status && Objects.equals(drink, that.drink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drink, amount, orderDrinkID, orderID, status);
    }
}
