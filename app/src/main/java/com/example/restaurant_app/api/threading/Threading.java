package com.example.restaurant_app.api.threading;

import android.os.Handler;
import android.os.Looper;

import com.example.restaurant_app.MenuData;
import com.example.restaurant_app.api.service.MenuService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Threading {



    public void startMenuThread(MenuService service) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {

            @Override
            public void run() {
                MenuData data = service.getMenu();

                handler.post(() -> updateUI(data));
            }
        });


    }

    public void updateUI(MenuData data) {

    }
}
