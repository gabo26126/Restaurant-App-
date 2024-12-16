package com.example.restaurant_app.orderManagement;

import com.example.restaurant_app.entity.MenuItem;

public class MenuItemModel {
    private MenuItem menuItem;
    private Integer numberOfItems;

    public MenuItemModel(MenuItem menuItem, Integer numberOfItems) {
        this.menuItem = menuItem;
        this.numberOfItems = numberOfItems;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }


}
