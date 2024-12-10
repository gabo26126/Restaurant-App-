package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;


public class KitchenFloorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_floor);

        Button pickKitchenButton = findViewById(R.id.kitchenButton);
        Button pickFloorButton = findViewById(R.id.floorButton);


        pickFloorButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                showChooseTableActivity();
            }
        });



        /*
        pickWorkButton.setOnClickListener(v -> {
            Intent intent = new Intent(KitchenFloorActivity.this, MainActivity.class);
            startActivity(intent);
        });
        */
    }

    public void showChooseTableActivity(){
        Intent chooseTableIntent = new Intent(KitchenFloorActivity.this, ChooseTableActivity.class);
        //chooseTableIntent.putExtra(messageKey, message);
        startActivity(chooseTableIntent);
    }
}