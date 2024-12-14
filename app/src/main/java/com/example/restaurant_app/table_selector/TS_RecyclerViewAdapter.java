package com.example.restaurant_app.table_selector;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.R;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TS_RecyclerViewAdapter extends RecyclerView.Adapter<TS_RecyclerViewAdapter.MyViewHolder> {

    Context context;

    ArrayList<TableSelectorModel> tableSelectorModels;

    public TS_RecyclerViewAdapter(Context context, ArrayList<TableSelectorModel> tableSelectorModels) {
        this.context = context;
        this.tableSelectorModels =tableSelectorModels;
    }

    @NonNull
    @Override
    public TS_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.choose_table_recycler_template, parent, false);

        return new TS_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TS_RecyclerViewAdapter.MyViewHolder holder, int position) {

        String title =tableSelectorModels.get(position).getTitle();
        holder.tableNumber.setText(title);

    }

    @Override
    public int getItemCount() {
        return tableSelectorModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tableNumber;

        ImageButton checkMarkImage;

        ImageButton penImage;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tableNumber = itemView.findViewById(R.id.tableText);
            checkMarkImage = itemView.findViewById(R.id.sendOrderButton);
            penImage = itemView.findViewById(R.id.editOrderButton);

        }


    }
}
