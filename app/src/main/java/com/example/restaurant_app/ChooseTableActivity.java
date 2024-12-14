package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
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
import com.example.restaurant_app.table_selector.TS_RecyclerViewAdapter;
import com.example.restaurant_app.table_selector.TableSelectorModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChooseTableActivity extends AppCompatActivity {


    APIInterface apiInterface;

    ArrayList<TableSelectorModel> tableSelectorModels = new ArrayList<>();

    RecyclerView recyclerView;

    TS_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_table);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Button createOrder = findViewById(R.id.addOrderButton);
        createOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseTableActivity.this, tablePopup.class));
            }
        });

        recyclerView = findViewById(R.id.chooseTableRecycler);



    }

    void setUpAdapter() {

        adapter = new TS_RecyclerViewAdapter(this, tableSelectorModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    void setUpTableSelectorModels() {
        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Order>> call = apiInterface.getAllOrders();
        call.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.body() != null) {
                    for(Order order : response.body()) {
                        tableSelectorModels.add(new TableSelectorModel(order));
                    }

                    setUpAdapter();
                }
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast toast = Toast.makeText(ChooseTableActivity.this, t.getMessage(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }




}