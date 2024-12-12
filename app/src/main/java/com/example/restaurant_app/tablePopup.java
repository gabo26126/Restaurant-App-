package com.example.restaurant_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tablePopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.7),(int)(height*.6));


        setupTableChoice(findViewById(android.R.id.content));

    }

    public void setupTableChoice(View rootView) {
        // Map button IDs directly to table numbers
        int[] buttonIds = {
                R.id.viewButton1, R.id.viewButton2, R.id.viewButton3,
                R.id.viewButton4, R.id.viewButton5, R.id.viewButton6,
                R.id.viewButton7, R.id.viewButton8, R.id.viewButton9,
                R.id.viewButton10
        };

        // Attach a single OnClickListener to all buttons
        for (int i = 0; i < buttonIds.length; i++) {
            final int tableNumber = i + 1; // Table numbers start at 1
            View button = rootView.findViewById(buttonIds[i]);
            if (button != null) {
                button.setOnClickListener(view -> showOrderActivity(tableNumber));
            }
        }
    }

    private void showOrderActivity(int tableNumber) {
        Intent chooseTableIntent = new Intent(tablePopup.this, MainActivity.class);
        chooseTableIntent.putExtra("TABLE_NUMBER", tableNumber);
        startActivity(chooseTableIntent);
    }
}