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

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.R;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class OC_RecyclerViewAdapter extends RecyclerView.Adapter<OC_RecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<OrderCardModel> orderCardModels;

    public OC_RecyclerViewAdapter(Context context, ArrayList<OrderCardModel> orderCardModels){
        this.context = context;
        this.orderCardModels = orderCardModels;
    }

    @NonNull
    @Override
    public OC_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating the layout (giving the look to each of our "rows")
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_test, parent, false);

        return new OC_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OC_RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views created in the recycler_view_test layout file
        // based on the position of the recycler view

        String title = orderCardModels.get(position).getTitle();
        holder.tableNumber.setText(title);

        String time = orderCardModels.get(position).getTime();
        holder.orderTime.setText(time);

        String description = orderCardModels.get(position).getCookingList();
        holder.orderDescription.setText(description);

    }

    @Override
    public int getItemCount() {
        return orderCardModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabbing the views from our recycler_view_test layout file

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
