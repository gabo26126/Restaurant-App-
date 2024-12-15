package com.example.restaurant_app;

import com.example.restaurant_app.MenuItems.Dessert;
import com.example.restaurant_app.MenuItems.Drink;
import com.example.restaurant_app.MenuItems.MainCourse;
import com.example.restaurant_app.MenuItems.Starter;

public class MenuData {
    private Drink [] drinks;
    private Starter [] starters;
    private MainCourse [] mainCourses;
    private Dessert [] desserts;


    // Getter for drinks
    public Drink [] getDrinks() {
        return drinks;
    }

    // Getter for starters
    public Starter[] getStarters() {
        return starters;
    }

    // Getter for mainCourses
    public MainCourse[] getMainCourses() {
        return mainCourses;
    }

    // Getter for desserts
    public Dessert[] getDesserts() {
        return desserts;
    }
}
