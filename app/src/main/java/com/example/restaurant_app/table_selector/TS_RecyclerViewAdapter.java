package com.example.restaurant_app.table_selector;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.ChooseTableActivity;
import com.example.restaurant_app.OrderManagementActivity;
import com.example.restaurant_app.R;
import com.example.restaurant_app.api.APIInterface;
import com.example.restaurant_app.api.ApiClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        String title = tableSelectorModels.get(position).getTitle();
        holder.tableNumber.setText(title);



        holder.checkMarkImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int orderID = tableSelectorModels.get(holder.getAdapterPosition()).getOrder().getOrderID();

                APIInterface apiInterface = ApiClient.getRetrofitInstance().create(APIInterface.class);
                Call<Void> call = apiInterface.removeOrder(orderID);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        tableSelectorModels.remove(holder.getAdapterPosition());
                        TS_RecyclerViewAdapter.this.notifyItemRemoved(holder.getAdapterPosition());

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast toast = Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
            }
        });

        holder.penImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderManagementIntent = new Intent(context, OrderManagementActivity.class);
                orderManagementIntent.putExtra("TABLE_NUMBER", tableSelectorModels.get(holder.getAdapterPosition()).getOrder().getTableNumber());
                orderManagementIntent.putExtra("IS_EDITING_ORDER", true);
                orderManagementIntent.putExtra("ORDER_ID", tableSelectorModels.get(holder.getAdapterPosition()).getOrder().getOrderID());
                context.startActivity(orderManagementIntent);
            }
        });


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
