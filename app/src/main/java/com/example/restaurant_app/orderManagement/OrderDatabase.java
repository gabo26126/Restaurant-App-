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
    public static void addOrderToDatabase(ArrayList<MenuItemModel> menuItemModelsStarter,
                                          ArrayList<MenuItemModel> menuItemModelsMainCourse,
                                          ArrayList<MenuItemModel> menuItemModelsDessert,
                                          ArrayList<MenuItemModel> menuItemModelsDrink,
                                          String notes,
                                          Integer tableNumber,
                                          OrderManagement orderManagement){

        Order order = new Order(
                null,
                null,
                null,
                null,
                null,
                null,
                notes,
                tableNumber);

        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<Order> call = apiInterface.addOrder(order);
        call.enqueue(new Callback<Order>() {
            @Override
            public void onResponse(Call<Order> call, Response<Order> response) {
                if(response.body() != null){
                    addToExistingOrder(menuItemModelsStarter, menuItemModelsMainCourse, menuItemModelsDessert, menuItemModelsDrink, response.body().getOrderID(), orderManagement);
                }
            }

            @Override
            public void onFailure(Call<Order> call, Throwable t) {
                //Toast toast = Toast.makeText(, t.getMessage(), Toast.LENGTH_LONG);
                //toast.show();
            }
        });
    }

    public static void addToExistingOrder(ArrayList<MenuItemModel> menuItemModelsStarter,
                                          ArrayList<MenuItemModel> menuItemModelsMainCourse,
                                          ArrayList<MenuItemModel> menuItemModelsDessert,
                                          ArrayList<MenuItemModel> menuItemModelsDrink,
                                          Integer orderID,
                                          OrderManagement orderManagement){
        AtomicInteger apiCallsMade = new AtomicInteger();
        Integer apiCallsRequired = menuItemModelsStarter.size() + menuItemModelsMainCourse.size() + menuItemModelsDessert.size() + menuItemModelsDrink.size();

        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        List<Call<Void>> calls = new ArrayList<>();

        // Add all API calls into an array
        for(MenuItemModel menuItemModel : menuItemModelsStarter){
            calls.add(apiInterface.addOrderStarter(new OrderStarters((Starter) menuItemModel.getMenuItem(), menuItemModel.getNumberOfItems(), 0, orderID, false)));
        }
        for(MenuItemModel menuItemModel : menuItemModelsMainCourse){
            calls.add(apiInterface.addOrderMainCourse(new OrderMainCourses((MainCourse) menuItemModel.getMenuItem(), menuItemModel.getNumberOfItems(), 0, orderID, false)));
        }
        for(MenuItemModel menuItemModel : menuItemModelsDessert){
            calls.add(apiInterface.addOrderDessert(new OrderDesserts((Dessert) menuItemModel.getMenuItem(), menuItemModel.getNumberOfItems(), 0, orderID, false)));
        }
        for(MenuItemModel menuItemModel : menuItemModelsDrink){
            calls.add(apiInterface.addOrderDrink(new OrderDrinks((Drink) menuItemModel.getMenuItem(), menuItemModel.getNumberOfItems(), 0, orderID, false)));
        }

        for(Call<Void> call : calls){
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        orderManagement.orderSuccess();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        orderManagement.orderSuccess();
                    }
                }
            });
        }
    }
}
