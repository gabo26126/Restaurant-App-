package com.example.restaurant_app.kitchen;

import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.entity.OrderDesserts;
import com.example.restaurant_app.entity.OrderMainCourses;
import com.example.restaurant_app.entity.OrderStarters;

public class OrderCardModel {
    private Order order;

    public OrderCardModel(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTitle(){
        return "Bord " + order.getTableNumber() + "\n";
    }

    public String getTime(){
        return order.getCreatedAt().substring(11);
    }

    public String getCookingList(){
        String description = "";

        Order order = getOrder();
        order.removeDoneObjects();
        if(order.getOrderStarters() != null && !order.getOrderStarters().isEmpty()){
            description += "\t\t\tStarter(s)\n";
        }
        for(OrderStarters orderStarter : order.getOrderStarters()){
            description += orderStarter.getAmount() + "x  " + orderStarter.getStarter().getName() + "\n";
        }
        description += "\n";

        if(order.getOrderMainCourses() != null && !order.getOrderMainCourses().isEmpty()){
            description += "\t\t\tMain Course(s)\n";
        }
        for(OrderMainCourses orderMainCourse : order.getOrderMainCourses()){
            description += orderMainCourse.getAmount() + "x  " + orderMainCourse.getMainCourse().getName() + "\n";
        }
        description += "\n";

        if(order.getOrderDesserts() != null && !order.getOrderDesserts().isEmpty()){
            description += "\t\t\tDessert(s)\n";
        }
        for(OrderDesserts orderDessert : order.getOrderDesserts()){
            description += orderDessert.getAmount() + "x  " + orderDessert.getDessert().getName() + "\n";
        }
        description += "\n";

        description += "\t\t\tNotes\n";
        description += order.getNotes();
        return description;
    }
}
