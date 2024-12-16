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
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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

    @DELETE("api/orders/{orderID}")
    Call<Void> removeOrder(@Path("orderID") int orderID);

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

    @PUT("api/order-main-courses/{orderMainCourseID}")
    Call<Void> orderUpdateMainCourse(
            @Path("orderMainCourseID") int orderMainCourseID,
            @Body OrderMainCourses orderMainCourses);

    @PUT("api/order-desserts/{orderDessertID}")
    Call<Void> orderUpdateDessert(
            @Path("orderDessertID") int orderDessertID,
            @Body OrderDesserts orderDesserts);

    @PUT("api/order-starters/{orderStarterID}")
    Call<Void> orderUpdateStarter(
            @Path("orderStarterID") int orderStarterID,
            @Body OrderStarters orderStarters);

    @PUT("api/order-drinks/{orderDrinkID}")
    Call<Void> orderUpdateDrink(
            @Path("orderDrinkID") int orderStarterID,
            @Body OrderDrinks orderDrinks);

}
