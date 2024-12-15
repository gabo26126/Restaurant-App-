package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Dessert;
import com.example.restaurant_app.entity.Drink;
import com.example.restaurant_app.entity.MainCourse;
import com.example.restaurant_app.entity.Starter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int Count = 13; // Antal rätter
        int starterNum = 2; //Antal förrätter-1
        int mainCourseNum = 3; //Antal varmrätter-1
        int dessertNum = 2; //Antal desserter-1
        int drinkNum = 2; //Antal drinkar-1

        int tableNumber = getIntent().getIntExtra("TABLE_NUMBER", -1);

        String layout = String.format("Bord %d", tableNumber);
        TextView textView = findViewById(R.id.tableName);
        textView.setText(layout);

        Button bordButton = findViewById(R.id.newtable);

        bordButton.setOnClickListener(view -> backToTable());

        getMenu(starterNum, mainCourseNum, dessertNum, drinkNum);

        // Loop genom alla rätter
        for (int i = 1; i <= Count; i++) {
            Button minusButton = findViewById(getResources().getIdentifier("minus" + i, "id", getPackageName()));
            Button plusButton = findViewById(getResources().getIdentifier("plus" + i, "id", getPackageName()));
            final TextView countTextView = findViewById(getResources().getIdentifier("Count" + i, "id", getPackageName()));

            final int index = i;  // Behöver detta för att korrekt uppdatera rätt räknare


            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateCount(countTextView, false, index); // Minska räknaren för den specifika rätten
                }
            });


            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateCount(countTextView, true, index); // Öka räknaren för den specifika rätten
                }
            });
        }
    }


    private void updateCount(TextView countTextView, boolean increase, int index) {
        int currentCount = Integer.parseInt(countTextView.getText().toString());
        if (increase) {
            currentCount++;
        } else {
            if (currentCount > 0) currentCount--;  // Förhindrar att räknaren går under 0
        }
        countTextView.setText(String.valueOf(currentCount));  // Uppdatera texten
    }

    private void backToTable(){
        Intent tableIntent = new Intent(MainActivity.this, ChooseTableActivity.class);
        startActivity(tableIntent);
    }


    private void getMenu(int starterNum, int mainCourseNum, int dessertNum, int drinkNum){
        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Starter>> call1 = apiInterface.getAllStarters();
        call1.enqueue(new Callback<List<Starter>>() {
            @Override
            public void onResponse(Call<List<Starter>> call, Response<List<Starter>> response) {
                for (int i = 0; i <= starterNum; i++){
                    TextView menuItem = findViewById(getResources().getIdentifier("starter" + i, "id", getPackageName()));
                    String starterItem = response.body().get(i).getName();
                    updateMenu(menuItem, starterItem);
                }
            }
            @Override
            public void onFailure(Call<List<Starter>> call, Throwable t) {
            }
        });

        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<MainCourse>> call2 = apiInterface.getAllMainCourses();
        call2.enqueue(new Callback<List<MainCourse>>() {
            @Override
            public void onResponse(Call<List<MainCourse>> call, Response<List<MainCourse>> response) {
                for (int i = 0; i <= mainCourseNum; i++){
                    TextView menuItem = findViewById(getResources().getIdentifier("mainCourse" + i, "id", getPackageName()));
                    String mainCourseItem = response.body().get(i).getName();
                    updateMenu(menuItem, mainCourseItem);
                }
            }
            @Override
            public void onFailure(Call<List<MainCourse>> call, Throwable t) {
            }
        });

        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Dessert>> call3 = apiInterface.getAllDesserts();
        call3.enqueue(new Callback<List<Dessert>>() {
            @Override
            public void onResponse(Call<List<Dessert>> call, Response<List<Dessert>> response) {
                for (int i = 0; i <= dessertNum; i++){
                    TextView menuItem = findViewById(getResources().getIdentifier("dessert" + i, "id", getPackageName()));
                    String dessertItem = response.body().get(i).getName();
                    updateMenu(menuItem, dessertItem);
                }
            }
            @Override
            public void onFailure(Call<List<Dessert>> call, Throwable t) {
            }
        });

        apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Drink>> call4 = apiInterface.getAllDrinks();
        call4.enqueue(new Callback<List<Drink>>() {
            @Override
            public void onResponse(Call<List<Drink>> call, Response<List<Drink>> response) {
                for (int i = 0; i <= drinkNum; i++){
                    TextView menuItem = findViewById(getResources().getIdentifier("drink" + i, "id", getPackageName()));
                    String drinkItem = response.body().get(i).getName();
                    updateMenu(menuItem, drinkItem);
                }
            }

            @Override
            public void onFailure(Call<List<Drink>> call, Throwable t) {

            }
        });

    }


    private void updateMenu(TextView menuItem, String item){
        menuItem.setText(item);
    }
}
