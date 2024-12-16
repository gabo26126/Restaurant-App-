package com.example.restaurant_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class tablePopup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.6),(int)(height*.5));


        setupTableChoice(findViewById(android.R.id.content));

        // Kod för att stänga popup eller göra någon annan åtgärd

    }
    public void closePopup(View view) {
        finish(); // Om du vill avsluta aktiviteten
        // Eller, om det är en popup, kan du dölja den:
        // findViewById(R.id.popupLayout).setVisibility(View.GONE);
    }

    public void setupTableChoice(View rootView) {
        // Map button IDs directly to table numbers
        int[] buttonIds = {
                R.id.chooseTable1, R.id.chooseTable2, R.id.chooseTable3,
                R.id.chooseTable4, R.id.chooseTable5, R.id.chooseTable6,
                R.id.chooseTable7, R.id.chooseTable8, R.id.chooseTable9,
                R.id.chooseTable10
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
        Intent chooseTableIntent = new Intent(tablePopup.this, OrderManagementActivity.class);
        chooseTableIntent.putExtra("TABLE_NUMBER", tableNumber);
        chooseTableIntent.putExtra("IS_EDITING_ORDER", false);
        startActivity(chooseTableIntent);
    }
}