package com.example.restaurant_app.kitchen;

public interface OrderAvailabilityHandler {
    void pauseRefreshing();
    void resumeRefreshing();
    void removeOrderCardModel(int position);
}
