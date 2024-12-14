package com.example.restaurant_app;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.kitchen.OC_RecyclerViewAdapter;
import com.example.restaurant_app.kitchen.OrderCardModel;
import com.example.restaurant_app.kitchen.helpers.OrderHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KitchenViewActivity extends AppCompatActivity {

    APIInterface apiInterface;
    ArrayList<OrderCardModel> orderCardModels = new ArrayList<>();
    RecyclerView recyclerView;
    OC_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_view);

        recyclerView = findViewById(R.id.mRecyclerView);

        setUpOrderCardModels();



    }

    void setUpAdapter(){
        adapter = new OC_RecyclerViewAdapter(this, orderCardModels);
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
                }


            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast toast = Toast.makeText(KitchenViewActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}