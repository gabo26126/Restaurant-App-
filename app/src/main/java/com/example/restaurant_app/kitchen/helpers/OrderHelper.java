package com.example.restaurant_app.kitchen.helpers;

import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.entity.OrderDesserts;
import com.example.restaurant_app.entity.OrderMainCourses;
import com.example.restaurant_app.entity.OrderStarters;

import java.util.List;

public class OrderHelper {

    public static List<Order> removeDoneOrders(List<Order> orders){
        orders.removeIf(order -> order.orderIsDone());
        return orders;
    }





}
