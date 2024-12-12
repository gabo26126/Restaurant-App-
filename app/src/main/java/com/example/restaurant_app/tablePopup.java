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

    public void setupTableChoice(View rootView){
        View table1View = rootView.findViewById(R.id.viewButton1);
        View table2View = rootView.findViewById(R.id.viewButton2);
        View table3View = rootView.findViewById(R.id.viewButton3);
        View table4View = rootView.findViewById(R.id.viewButton4);
        View table5View = rootView.findViewById(R.id.viewButton5);
        View table6View = rootView.findViewById(R.id.viewButton6);
        View table7View = rootView.findViewById(R.id.viewButton7);
        View table8View = rootView.findViewById(R.id.viewButton8);
        View table9View = rootView.findViewById(R.id.viewButton9);
        View table10View = rootView.findViewById(R.id.viewButton10);

        table1View.setOnClickListener(view -> showOrderActivity());
    }

    private void showOrderActivity(){
        Intent chooseTableIntent = new Intent(tablePopup.this, MainActivity.class);
        startActivity(chooseTableIntent);
    }
}