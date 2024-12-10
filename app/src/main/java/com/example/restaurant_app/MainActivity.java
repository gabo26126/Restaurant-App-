package com.example.restaurant_app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int Count = 2; // Antal rätter

        // Loop genom alla rätter
        for (int i = 1; i <= Count; i++) {
            Button minusButton = findViewById(getResources().getIdentifier("minus" + i, "id", getPackageName()));
            Button plusButton = findViewById(getResources().getIdentifier("plus" + i, "id", getPackageName()));
            final TextView countTextView = findViewById(getResources().getIdentifier("Count" + i, "id", getPackageName()));

            final int index = i;  // Behöver detta för att korrekt uppdatera rätt räknare

            // Sätt klickhanterare för minus-knappen
            minusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateCount(countTextView, false, index); // Minska räknaren för den specifika rätten
                }
            });

            // Sätt klickhanterare för plus-knappen
            plusButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    updateCount(countTextView, true, index); // Öka räknaren för den specifika rätten
                }
            });
        }
    }

    // Metod för att uppdatera räknaren
    private void updateCount(TextView countTextView, boolean increase, int index) {
        int currentCount = Integer.parseInt(countTextView.getText().toString());
        if (increase) {
            currentCount++;
        } else {
            if (currentCount > 0) currentCount--;  // Förhindrar att räknaren går under 0
        }
        countTextView.setText(String.valueOf(currentCount));  // Uppdatera texten
    }
}
