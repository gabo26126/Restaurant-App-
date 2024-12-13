package com.example.restaurant_app.entity;

import java.util.List;

public class Menu {
    private List<Starter> starters;
    private List<MainCourse> mainCourses;
    private List<Dessert> desserts;
    private List<Drink> drinks;

    public List<Starter> getStarters() {
        return starters;
    }

    public void setStarters(List<Starter> starters) {
        this.starters = starters;
    }

    public List<MainCourse> getMainCourses() {
        return mainCourses;
    }

    public void setMainCourses(List<MainCourse> mainCourses) {
        this.mainCourses = mainCourses;
    }

    public List<Dessert> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Dessert> desserts) {
        this.desserts = desserts;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
