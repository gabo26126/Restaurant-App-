package com.example.restaurant_app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Dessert;
import com.example.restaurant_app.entity.Drink;
import com.example.restaurant_app.entity.MainCourse;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.entity.Starter;
import com.example.restaurant_app.orderManagement.MenuItemModel;
import com.example.restaurant_app.orderManagement.MenuRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class OrderManagementActivity extends AppCompatActivity {

        private APIInterface apiInterface;

        private RecyclerView recyclerViewStarters;
        private RecyclerView recyclerViewMainCourses;
        private RecyclerView recyclerViewDesserts;
        private RecyclerView recyclerViewDrinks;
        private ArrayList<MenuItemModel> menuItemModelsStarter = new ArrayList<>();
        private ArrayList<MenuItemModel> menuItemModelsMainCourse = new ArrayList<>();
        private ArrayList<MenuItemModel> menuItemModelsDessert = new ArrayList<>();
        private ArrayList<MenuItemModel> menuItemModelsDrink = new ArrayList<>();
        private MenuRecyclerViewAdapter adapterStarters;
        private MenuRecyclerViewAdapter adapterMainCourses;
        private MenuRecyclerViewAdapter adapterDesserts;
        private MenuRecyclerViewAdapter adapterDrinks;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order_management);

            int tableNumber = getIntent().getIntExtra("TABLE_NUMBER", -1);

            recyclerViewStarters = findViewById(R.id.starterRecyclerView);
            recyclerViewMainCourses = findViewById(R.id.mainCourseRecyclerView);
            recyclerViewDesserts = findViewById(R.id.dessertRecyclerView);
            recyclerViewDrinks = findViewById(R.id.drinkRecyclerView);

            setUpMenuItemModels();

        }

        void setUpAdapters(){
            adapterStarters = new MenuRecyclerViewAdapter(this, menuItemModelsStarter);
            recyclerViewStarters.setAdapter(adapterStarters);
            recyclerViewStarters.setLayoutManager(new LinearLayoutManager(this));
            adapterMainCourses = new MenuRecyclerViewAdapter(this, menuItemModelsMainCourse);
            recyclerViewMainCourses.setAdapter(adapterMainCourses);
            recyclerViewMainCourses.setLayoutManager(new LinearLayoutManager(this));
            adapterDesserts = new MenuRecyclerViewAdapter(this, menuItemModelsDessert);
            recyclerViewDesserts.setAdapter(adapterDesserts);
            recyclerViewDesserts.setLayoutManager(new LinearLayoutManager(this));
            adapterDrinks = new MenuRecyclerViewAdapter(this, menuItemModelsDrink);
            recyclerViewDrinks.setAdapter(adapterDrinks);
            recyclerViewDrinks.setLayoutManager(new LinearLayoutManager(this));
        }


        void setUpMenuItemModels(){
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Integer apiCallRequired = 4;

            apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
            Call<List<Starter>> callStarters = apiInterface.getAllStarters();
            callStarters.enqueue(new Callback<List<Starter>>() {
                @Override
                public void onResponse(Call<List<Starter>> call, Response<List<Starter>> response) {
                    if(response.body() != null){
                        for(Starter starter : response.body()){
                            menuItemModelsStarter.add(new MenuItemModel(starter, 0));
                        }
                        int apiCallsMade = atomicInteger.incrementAndGet();
                        if(apiCallsMade == apiCallRequired){
                            setUpAdapters();
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<Starter>> call, Throwable t) {
                    Toast toast = Toast.makeText(OrderManagementActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            });

            Call<List<MainCourse>> callMainCourses = apiInterface.getAllMainCourses();
            callMainCourses.enqueue(new Callback<List<MainCourse>>() {
                @Override
                public void onResponse(Call<List<MainCourse>> call, Response<List<MainCourse>> response) {
                    if(response.body() != null){
                        for(MainCourse mainCourse : response.body()){
                            menuItemModelsMainCourse.add(new MenuItemModel(mainCourse, 0));
                        }
                        int apiCallsMade = atomicInteger.incrementAndGet();
                        if(apiCallsMade == apiCallRequired){
                            setUpAdapters();
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<MainCourse>> call, Throwable t) {
                    Toast toast = Toast.makeText(OrderManagementActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            });

            Call<List<Dessert>> callDesserts = apiInterface.getAllDesserts();
            callDesserts.enqueue(new Callback<List<Dessert>>() {
                @Override
                public void onResponse(Call<List<Dessert>> call, Response<List<Dessert>> response) {
                    if(response.body() != null){
                        for(Dessert dessert : response.body()){
                            menuItemModelsDessert.add(new MenuItemModel(dessert, 0));
                        }
                        int apiCallsMade = atomicInteger.incrementAndGet();
                        if(apiCallsMade == apiCallRequired){
                            setUpAdapters();
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<Dessert>> call, Throwable t) {
                    Toast toast = Toast.makeText(OrderManagementActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            });

            Call<List<Drink>> callDrinks = apiInterface.getAllDrinks();
            callDrinks.enqueue(new Callback<List<Drink>>() {
                @Override
                public void onResponse(Call<List<Drink>> call, Response<List<Drink>> response) {
                    if(response.body() != null){
                        for(Drink drink : response.body()){
                            menuItemModelsDrink.add(new MenuItemModel(drink, 0));
                        }
                        int apiCallsMade = atomicInteger.incrementAndGet();
                        if(apiCallsMade == apiCallRequired){
                            setUpAdapters();
                        }
                    }
                }
                @Override
                public void onFailure(Call<List<Drink>> call, Throwable t) {
                    Toast toast = Toast.makeText(OrderManagementActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                    toast.show();
                }
            });
        }
    }
