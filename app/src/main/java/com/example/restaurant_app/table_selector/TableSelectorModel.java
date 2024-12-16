package com.example.restaurant_app.table_selector;

import com.example.restaurant_app.entity.Order;

public class TableSelectorModel {

    private Order order;

    public TableSelectorModel(Order order) { this.order = order; }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public String getTitle() { return "Bord " + order.getTableNumber() +  "\n"; }


}
