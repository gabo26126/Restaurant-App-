package com.example.restaurant_app.orderManagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurant_app.R;

import java.util.ArrayList;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<MenuItemModel> menuItemModels;

    public MenuRecyclerViewAdapter(Context context, ArrayList<MenuItemModel> menuItemModels){
        this.context = context;
        this.menuItemModels = menuItemModels;
    }

    @NonNull
    @Override
    public MenuRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // inflating the layout (giving the look to the grid)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item_recycler_view, parent, false);

        return new MenuRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views created in the recycler_view_test layout file
        // based on the position of the recycler view

        // Display name of menuItem
        String name = menuItemModels.get(position).getMenuItem().getName();
        holder.name.setText(name);

        // Start by displaying a count of zero
        Integer numberOfItems = menuItemModels.get(position).getNumberOfItems();
        holder.count.setText(String.valueOf(numberOfItems));

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer currentNumberOfItems = menuItemModels.get(holder.getAdapterPosition()).getNumberOfItems();
                holder.count.setText(String.valueOf(currentNumberOfItems + 1));
                menuItemModels.get(holder.getAdapterPosition()).setNumberOfItems(currentNumberOfItems + 1);
            }
        });

        holder.subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer currentNumberOfItems = menuItemModels.get(holder.getAdapterPosition()).getNumberOfItems();
                if(currentNumberOfItems > 0){
                    holder.count.setText(String.valueOf(currentNumberOfItems - 1));
                    menuItemModels.get(holder.getAdapterPosition()).setNumberOfItems(currentNumberOfItems - 1);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuItemModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageButton add, subtract;
        TextView name, count;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            add = itemView.findViewById(R.id.menuItemAdd);
            subtract = itemView.findViewById(R.id.menuItemSubtract);
            name = itemView.findViewById(R.id.menuItemInfo);
            count = itemView.findViewById(R.id.itemCounter);

        }
    }
}
