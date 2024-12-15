package com.example.restaurant_app;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.kitchen.OC_RecyclerViewAdapter;
import com.example.restaurant_app.kitchen.OrderAvailabilityHandler;
import com.example.restaurant_app.kitchen.OrderCardModel;
import com.example.restaurant_app.kitchen.helpers.OrderHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KitchenViewActivity extends AppCompatActivity implements OrderAvailabilityHandler {

    private APIInterface apiInterface;
    private ArrayList<OrderCardModel> orderCardModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private OC_RecyclerViewAdapter adapter;

    private Handler handler = new Handler();
    private Runnable refreshRunnable;
    private boolean refreshingIsPaused = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_view);

        recyclerView = findViewById(R.id.mRecyclerView);

        setUpOrderCardModels();

        // set to refresh the page every 10 seconds
        refreshRunnable = new Runnable() {
            @Override
            public void run() {
                if (!refreshingIsPaused) {
                    refreshOrders(); // Call your function
                }
                // Schedule the next execution after 10 seconds
                handler.postDelayed(this, 10000);
            }
        };
        handler.post(refreshRunnable);

    }

    // Set up adapter of
    void setUpAdapter(){
        adapter = new OC_RecyclerViewAdapter(this, orderCardModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setNestedScrollingEnabled(true);
    }

    void setUpOrderCardModels(){
        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Order>> call = apiInterface.getAllOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.body() != null){
                    List<Order> orders = OrderHelper.removeDoneOrders(response.body());
                    for(Order order : orders){
                        orderCardModels.add(new OrderCardModel(order));
                    }
                    setUpAdapter();
                    resumeRefreshing();
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast toast = Toast.makeText(KitchenViewActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    // refresh OrderCardModels
    void refreshOrderCardModels(){
        adapter.notifyDataSetChanged();
    }

    public void pauseRefreshing(){
        refreshingIsPaused = true;
    }

    public void resumeRefreshing(){
        refreshingIsPaused = false;
    }

    // only use this if the order card at @param position
    // has already been removed from database
    public void removeOrderCardModel(int position){
        adapter.removeOrderCardModel(position);
        adapter.notifyItemRemoved(position);
        resumeRefreshing();
    }


    public void refreshOrders(){
        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Order>> call = apiInterface.getAllOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.body() != null){
                    // remove orders that doesn't have any cookable elements
                    List<Order> orders = OrderHelper.removeDoneOrders(response.body());
                    ArrayList<OrderCardModel> orderCardModelsTemp = new ArrayList<>();
                    for(Order order : orders){
                        orderCardModelsTemp.add(new OrderCardModel(order));
                    }
                    // if the orders in the database is different, refresh the order cards
                    if(!orderCardModelsTemp.equals(orderCardModels)){
                        adapter.setOrderCardModels(orderCardModelsTemp);
                        refreshOrderCardModels();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                System.err.println(t.getMessage());
                Toast toast = Toast.makeText(KitchenViewActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(refreshRunnable); // Stop the Runnable when the activity is destroyed
    }
}