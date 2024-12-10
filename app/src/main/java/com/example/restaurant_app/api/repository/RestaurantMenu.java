package com.example.restaurant_app.api.repository;

import com.example.restaurant_app.MenuData;

public interface RestaurantMenu {
    MenuData fetchMenuData() throws Exception;
}
