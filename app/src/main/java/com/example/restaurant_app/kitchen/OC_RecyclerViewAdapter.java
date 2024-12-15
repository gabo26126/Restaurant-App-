package com.example.restaurant_app.kitchen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.KitchenViewActivity;
import com.example.restaurant_app.MainActivity;
import com.example.restaurant_app.R;
import com.example.restaurant_app.entity.Order;
import com.example.restaurant_app.kitchen.helpers.OrderChangeStatusHelper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class OC_RecyclerViewAdapter extends RecyclerView.Adapter<OC_RecyclerViewAdapter.MyViewHolder> {

    OrderAvailabilityHandler orderAvailabilityHandler;
    private Context context;
    private ArrayList<OrderCardModel> orderCardModels;

    public ArrayList<OrderCardModel> getOrderCardModels() {
        return orderCardModels;
    }

    public void setOrderCardModels(ArrayList<OrderCardModel> orderCardModels) {
        this.orderCardModels = orderCardModels;
    }

    public void removeOrderCardModel(int position){
        orderCardModels.remove(position);
    }

    public OC_RecyclerViewAdapter(Context context, ArrayList<OrderCardModel> orderCardModels, OrderAvailabilityHandler orderAvailabilityHandler){
        this.context = context;
        this.orderCardModels = orderCardModels;
        this.orderAvailabilityHandler = orderAvailabilityHandler;
    }

    @NonNull
    @Override
    public OC_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating the layout (giving the look to the grid)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_test, parent, false);

        return new OC_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OC_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views created in the recycler_view_test layout file
        // based on the position of the recycler view
        OrderCardModel orderCardModel = orderCardModels.get(position);
        Order order = orderCardModel.getOrder();

        String title = orderCardModel.getTitle();
        holder.tableNumber.setText(title);

        String time = orderCardModel.getTime();
        holder.orderTime.setText(time);

        String description = orderCardModel.getCookingList();
        holder.orderDescription.setText(description);

        // set click function to clear the order
        holder.orderDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderAvailabilityHandler.pauseRefreshing();
                OrderChangeStatusHelper orderChangeStatusHelper = new OrderChangeStatusHelper(
                        order.getOrderStarters(),
                        order.getOrderMainCourses(),
                        order.getOrderDesserts(),
                        orderAvailabilityHandler,
                        holder.getAdapterPosition()
                );
                orderChangeStatusHelper.changeStatusOfAllObjects();
            }
        });

    }

    @Override
    public int getItemCount() {
        return orderCardModels.size();
    }

    // basically the constructor
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabbing the views from recycler_view_test layout file

        TextView tableNumber;
        TextView orderDescription;
        TextView orderTime;
        ImageButton orderDoneButton;
        ScrollView scrollView;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tableNumber = itemView.findViewById(R.id.TableNumb);
            orderDescription = itemView.findViewById(R.id.OrderDesc);
            orderTime = itemView.findViewById(R.id.orderTime);
            orderDoneButton = itemView.findViewById(R.id.OrderDone);
            scrollView = itemView.findViewById(R.id.orderScrollView);
            linearLayout = itemView.findViewById(R.id.orderLinearLayout);

        }
    }
}
