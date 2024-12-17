package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Vänta i 3 sekunder innan vi startar huvudaktiviteten
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Starta den riktiga huvudaktiviteten
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Stäng splash activity
                finish();
            }
        }, 3000); // 3000 millisekunder = 3 sekunder
    }
}
