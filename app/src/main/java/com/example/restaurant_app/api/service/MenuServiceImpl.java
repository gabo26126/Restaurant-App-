package com.example.restaurant_app.api.service;

import android.view.Menu;

import com.example.restaurant_app.MenuData;
import com.example.restaurant_app.api.repository.RestaurantMenu;
import com.example.restaurant_app.api.repository.RestaurantMenuImpl;

public class MenuServiceImpl implements MenuService{

    private RestaurantMenu menu;

    public MenuServiceImpl() { this.menu = new RestaurantMenuImpl(); }

    public MenuData getMenu() {
        try {
            return menu.fetchMenuData();
        } catch (Exception e) {
            return null;
        }
    }
}
