package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;


public class KitchenFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_floor);

        Button pickWorkButton = findViewById(R.id.floorButton);

        pickWorkButton.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenFloorActivity.this, MainActivity.class);
            startActivity(intent);
        });

        Button pickKitchenButton = findViewById(R.id.kitchenButton);

        pickKitchenButton.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenFloorActivity.this, KitchenViewActivity.class);
            startActivity(intent);
        });
    }
}