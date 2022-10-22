package com.metropolitan.foodorderapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.metropolitan.foodorderapp.R;
import com.metropolitan.foodorderapp.model.Menu;

import java.util.List;

public class PlaceYourOrderAdapter extends RecyclerView.Adapter<PlaceYourOrderAdapter.MyViewHolder> {

    private List<Menu> menuList;

    public PlaceYourOrderAdapter(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void updateData(List<Menu> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PlaceYourOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.place_order_recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceYourOrderAdapter.MyViewHolder holder, int position) {
        holder.menuName.setText(menuList.get(position).getName());
        holder.menuPrice.setText("Price: $" + String.format("%.2f", menuList.get(position).getTotalInCart() * menuList.get(position).getPrice()));
        holder.menuQuantity.setText("Quantity: " + menuList.get(position).getTotalInCart());

        Glide.with(holder.thumbImage).load(menuList.get(position).getUrl()).into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbImage;
        TextView menuName;
        TextView menuPrice;
        TextView menuQuantity;

        public MyViewHolder(View view) {
            super(view);
            thumbImage = view.findViewById(R.id.thumbImage);
            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            menuQuantity = view.findViewById(R.id.menuQuantity);
        }

    }

}