package com.example.restaurant_app.orderManagement;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Dessert;
import com.example.restaurant_app.entity.Drink;
import com.example.restaurant_app.entity.MainCourse;
import com.example.restaurant_app.entity.Menu;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.entity.OrderDesserts;
import com.example.restaurant_app.entity.OrderDrinks;
import com.example.restaurant_app.entity.OrderMainCourses;
import com.example.restaurant_app.entity.OrderStarters;
import com.example.restaurant_app.entity.Starter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderDatabase {
    public static void addOrderToDatabase(Menu menu, String notes, Integer tableNumber, OrderManagement orderManagement){

        Order order = new Order(
                null,
                null,
                null,
                null,
                null,
                null,
                notes,
                1);

        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<Order> call = apiInterface.addOrder(order);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.body() != null){
                    addMenuToOrderID(menu, orderManagement, response.body().getOrderID());
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                //Toast toast = Toast.makeText(, t.getMessage(), Toast.LENGTH_LONG);
                //toast.show();
            }
        });
    }

    private static void addMenuToOrderID(Menu menu, OrderManagement orderManagement, Integer orderID){
        AtomicInteger apiCallsMade = new AtomicInteger();
        Integer apiCallsRequired = menu.getDesserts().size() + menu.getStarters().size() + menu.getMainCourses().size() + menu.getDrinks().size();

        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        List<Call<Void>> calls = new ArrayList<>();

        // Add all API calls into an array
        for(Starter starter : menu.getStarters()){
            calls.add(apiInterface.addOrderStarter(new OrderStarters(starter, 1, 0, orderID, false)));
        }
        for(MainCourse mainCourse : menu.getMainCourses()){
            calls.add(apiInterface.addOrderMainCourse(new OrderMainCourses(mainCourse, 1, 0, orderID, false)));
        }
        for(Dessert dessert : menu.getDesserts()){
            calls.add(apiInterface.addOrderDessert(new OrderDesserts(dessert, 1, 0, orderID, false)));
        }
        for(Drink drink : menu.getDrinks()){
            calls.add(apiInterface.addOrderDrink(new OrderDrinks(drink, 1, 0, orderID, false)));
        }

        for(Call<Void> call : calls){
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        orderManagement.orderCreated();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        orderManagement.orderCreated();
                    }
                }
            });
        }
    }
}
