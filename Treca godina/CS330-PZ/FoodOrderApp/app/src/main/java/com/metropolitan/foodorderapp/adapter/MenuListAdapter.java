package com.metropolitan.foodorderapp.adapter;

import android.annotation.SuppressLint;
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
import com.metropolitan.foodorderapp.model.RestaurantModel;

import java.util.ArrayList;
import java.util.List;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MyViewHolder> {

    private List<Menu> menuList;
    private MenuListClickListener clickListener;

    public MenuListAdapter(List<Menu> menuList, MenuListClickListener clickListener) {
        this.menuList = menuList;
        this.clickListener = clickListener;
    }

    public void updateData(List<Menu> menuList) {
        this.menuList = menuList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MenuListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MenuListAdapter.MyViewHolder holder, int position) {
        holder.menuName.setText(menuList.get(position).getName());
        holder.menuPrice.setText("Price: $" + menuList.get(position).getPrice());
        holder.addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu menu = menuList.get(position);
                menu.setTotalInCart(1);
                clickListener.onAddToCartClick(menu);
                holder.addMoreLayout.setVisibility(View.VISIBLE);
                holder.addToCartButton.setVisibility(View.GONE);
                holder.counter.setText(menu.getTotalInCart() + "");
            }
        });
        holder.imageMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu menu = menuList.get(position);
                int total = menu.getTotalInCart();
                total--;
                if (total > 0) {
                    menu.setTotalInCart(total);
                    clickListener.onUpdateCartClick(menu);
                    holder.counter.setText(total + "");
                } else {
                    holder.addMoreLayout.setVisibility(View.GONE);
                    holder.addToCartButton.setVisibility(View.VISIBLE);
                    menu.setTotalInCart(total);
                    clickListener.onRemoveFromCartClick(menu);
                }
            }
        });
        holder.imagePlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Menu menu = menuList.get(position);
                int total = menu.getTotalInCart();
                total++;
                if (total <= 10) {
                    menu.setTotalInCart(total);
                    clickListener.onUpdateCartClick(menu);
                    holder.counter.setText(total + "");
                }
            }
        });

        Glide.with(holder.thumbImage).load(menuList.get(position).getUrl()).into(holder.thumbImage);
    }

    @Override
    public int getItemCount() {
        if (menuList != null) {
            return menuList.size();
        }
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView thumbImage;
        TextView menuName;
        TextView menuPrice;
        TextView addToCartButton;
        ImageView imageMinus;
        TextView counter;
        ImageView imagePlus;
        LinearLayout addMoreLayout;

        public MyViewHolder(View view) {
            super(view);
            thumbImage = view.findViewById(R.id.thumbImage);
            menuName = view.findViewById(R.id.menuName);
            menuPrice = view.findViewById(R.id.menuPrice);
            addToCartButton = view.findViewById(R.id.addToCartButton);
            imageMinus = view.findViewById(R.id.imageMinus);
            counter = view.findViewById(R.id.counter);
            imagePlus = view.findViewById(R.id.imagePlus);
            addMoreLayout = view.findViewById(R.id.addMoreLayout);
        }

    }

    public interface MenuListClickListener {
        public void onAddToCartClick(Menu menu);
        public void onUpdateCartClick(Menu menu);
        public void onRemoveFromCartClick(Menu menu);
    }

}