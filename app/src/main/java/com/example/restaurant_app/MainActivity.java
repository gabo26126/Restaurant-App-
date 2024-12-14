package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import java.util.ArrayList;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;
import com.example.restaurant_app.entity.Drink;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Få bordets nummer från intent
        int tableNumber = getIntent().getIntExtra("TABLE_NUMBER", -1);
        TextView textView = findViewById(R.id.tableName);
        textView.setText(String.format("Bord %d", tableNumber));

        // Tillbaka-knapp
        Button bordButton = findViewById(R.id.newtable);
        bordButton.setOnClickListener(view -> backToTable());

        // Ladda menyer för drickor
        loadDrinksMenu();

        // Skapa knappar för fasta maträtter (ex. Count 10)
        setupFixedDishes(10);
    }

    // Ladda drickmenyn via API
    private void loadDrinksMenu() {
        APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
        Call<List<Drink>> call = apiInterface.getAllDrinks();

        call.enqueue(new Callback<List<Drink>>() {
            @Override
            public void onResponse(Call<List<Drink>> call, Response<List<Drink>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Drink> drinks = response.body();
                    setupDrinks(drinks);  // Skapa dynamiska vyer för drickor
                } else {
                    Log.e("API_ERROR", "Failed to fetch drinks: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Drink>> call, Throwable t) {
                Log.e("API_ERROR", "Error: " + t.getMessage());
            }
        });
    }

    // Dynamiskt skapa drickvyer
    private void setupDrinks(List<Drink> drinks) {
        // Hitta Spinnern i layouten
        Spinner drinkSpinner = findViewById(R.id.drinkSpinner);

        // Skapa en lista med namnen på drickorna
        List<String> drinkNames = new ArrayList<>();
        for (Drink drink : drinks) {
            drinkNames.add(drink.getName());  // Lägg till namnet på varje drink i listan
        }
        Log.d("SetupDrinks", "Drink Names: " + drinkNames.toString());
        if (drinkNames.isEmpty()) {
            Log.e("SetupDrinks", "No drinks found to display.");
        }

        // Skapa en ArrayAdapter för att visa drickorna i Spinnern
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, drinkNames);  // Använd en standard layout för spinnern

        // Sätt en dropdown layout
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Sätt adapter för Spinnern
        drinkSpinner.setAdapter(spinnerAdapter);

        // Lägg till en OnItemSelectedListener om du vill fånga vilket val som görs
        drinkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedDrink = parentView.getItemAtPosition(position).toString();
                Log.d("SelectedDrink", selectedDrink);  // Logga den valda drinken
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Om inget är valt
            }
        });
    }


    // Uppdatera drickantal
    private void updateDrinkCount(TextView countTextView, boolean increase) {
        int currentCount = Integer.parseInt(countTextView.getText().toString());
        if (increase) {
            currentCount++;
        } else if (currentCount > 0) {
            currentCount--;
        }
        countTextView.setText(String.valueOf(currentCount));
    }

    // Skapa fasta maträtter
    private void setupFixedDishes(int count) {
        for (int i = 1; i <= count; i++) {
            Button minusButton = findViewById(getResources().getIdentifier("minus" + i, "id", getPackageName()));
            Button plusButton = findViewById(getResources().getIdentifier("plus" + i, "id", getPackageName()));
            TextView countTextView = findViewById(getResources().getIdentifier("Count" + i, "id", getPackageName()));

            minusButton.setOnClickListener(v -> updateDishCount(countTextView, false));
            plusButton.setOnClickListener(v -> updateDishCount(countTextView, true));
        }
    }

    // Uppdatera maträttantal
    private void updateDishCount(TextView countTextView, boolean increase) {
        int currentCount = Integer.parseInt(countTextView.getText().toString());
        if (increase) {
            currentCount++;
        } else if (currentCount > 0) {
            currentCount--;
        }
        countTextView.setText(String.valueOf(currentCount));
    }

    // Tillbaka till bord-vy
    private void backToTable() {
        Intent tableIntent = new Intent(MainActivity.this, ChooseTableActivity.class);
        startActivity(tableIntent);
    }
}
