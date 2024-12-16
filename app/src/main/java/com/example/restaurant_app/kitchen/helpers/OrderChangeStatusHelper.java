package com.example.restaurant_app.kitchen.helpers;

import android.widget.Toast;

import com.example.restaurant_app.MainActivity;
import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.OrderDesserts;
import com.example.restaurant_app.entity.OrderMainCourses;
import com.example.restaurant_app.entity.OrderStarters;
import com.example.restaurant_app.kitchen.OrderAvailabilityHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderChangeStatusHelper {
    private AtomicInteger apiCallsMade;
    private int apiCallsRequired;
    private List<OrderStarters> orderStarters;
    private List<OrderMainCourses> orderMainCourses;
    private List<OrderDesserts> orderDesserts;
    private OrderAvailabilityHandler orderAvailabilityHandler;
    private int position;

    public OrderChangeStatusHelper(List<OrderStarters> orderStarters, List<OrderMainCourses> orderMainCourses, List<OrderDesserts> orderDesserts, OrderAvailabilityHandler orderAvailabilityHandler, int position) {
        this.orderStarters = orderStarters;
        this.orderMainCourses = orderMainCourses;
        this.orderDesserts = orderDesserts;
        this.orderAvailabilityHandler = orderAvailabilityHandler;
        this.position = position;
        this.apiCallsMade = new AtomicInteger(0);
        this.apiCallsRequired = orderStarters.size() + orderMainCourses.size() + orderDesserts.size();
        for(OrderStarters orderStarter : this.orderStarters){
            orderStarter.setStatus(true);
        }
        for(OrderMainCourses orderMainCourse : this.orderMainCourses){
            orderMainCourse.setStatus(true);
        }
        for(OrderDesserts orderDessert : this.orderDesserts){
            orderDessert.setStatus(true);
        }
    }

    // set all objects status variable to true is the database
    public void changeStatusOfAllObjects(){
        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        List<Call<Void>> calls = new ArrayList<>();
        for(OrderStarters orderStarter : orderStarters){
            calls.add(apiInterface.orderUpdateStarter(orderStarter.getOrderStarterID(), orderStarter));
        }
        for(OrderMainCourses orderMainCourse : orderMainCourses){
            calls.add(apiInterface.orderUpdateMainCourse(orderMainCourse.getOrderMainCourseID(), orderMainCourse));
        }
        for(OrderDesserts orderDessert : orderDesserts){
            calls.add(apiInterface.orderUpdateDessert(orderDessert.getOrderDessertID(), orderDessert));
        }

        for(Call<Void> call : calls){
            call.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        onAllApiCallsMade();
                    }
                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {
                    System.err.println("Error changing order");
                    int currentCount = apiCallsMade.incrementAndGet();

                    // check if all calls has been made
                    if(currentCount == apiCallsRequired){
                        onAllApiCallsMade();
                    }
                }
            });
        }


    }

    // will be called apiCallsRequired is reached
    private void onAllApiCallsMade(){
        orderAvailabilityHandler.removeOrderCardModel(position);
    }


}
