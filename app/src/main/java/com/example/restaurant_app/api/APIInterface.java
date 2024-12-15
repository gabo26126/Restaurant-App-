package com.example.restaurant_app.api;

import com.example.restaurant_app.entity.Dessert;
import com.example.restaurant_app.entity.Drink;
import com.example.restaurant_app.entity.MainCourse;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.entity.OrderDesserts;
import com.example.restaurant_app.entity.OrderDrinks;
import com.example.restaurant_app.entity.OrderMainCourses;
import com.example.restaurant_app.entity.OrderStarters;
import com.example.restaurant_app.entity.Starter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIInterface {
    //@GET("api/desserts/1")
    //Call<Dessert> getDessert();

    @GET("api/orders")
    Call<List<Order>> getAllOrders();

    @GET("api/starters")
    Call<List<Starter>> getAllStarters();

    @GET("api/maincourses")
    Call<List<MainCourse>> getAllMainCourses();

    @GET("api/desserts")
    Call<List<Dessert>> getAllDesserts();

    @GET("api/drinks")
    Call<List<Drink>> getAllDrinks();

    @POST("api/orders")
    Call<Order> addOrder(@Body Order order);

    @POST("api/order-starters")
    Call<Void> addOrderStarter(@Body OrderStarters orderStarters);

    @POST("api/order-main-courses")
    Call<Void> addOrderMainCourse(@Body OrderMainCourses orderMainCourses);

    @POST("api/order-desserts")
    Call<Void> addOrderDessert(@Body OrderDesserts orderDesserts);

    @POST("api/order-drinks")
    Call<Void> addOrderDrink(@Body OrderDrinks orderDrinks);
}
