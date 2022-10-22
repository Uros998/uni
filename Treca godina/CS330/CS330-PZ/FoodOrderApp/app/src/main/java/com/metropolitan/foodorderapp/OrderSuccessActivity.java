package com.metropolitan.foodorderapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.metropolitan.foodorderapp.adapter.DBAdapter;
import com.metropolitan.foodorderapp.model.RestaurantModel;

public class OrderSuccessActivity extends AppCompatActivity {

    static DBAdapter db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);

        db = new DBAdapter(this);

        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(restaurantModel.getName());
        actionBar.setSubtitle(restaurantModel.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(false);

        TextView buttonDone = findViewById(R.id.buttonDone);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFoodOrdered();
                try {
                    Thread.sleep(6000);
                    deleteFoodOrdered();
                    clearDB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finish();
            }
        });
    }

    private void showFoodOrdered() {
        db.open();
        Cursor c = db.getAllFoodOrders();
        if (c.moveToFirst()) {
            do {
                DisplayFoodOrdered(c);
            } while (c.moveToNext());
        }
        db.close();
    }

    private void deleteFoodOrdered() {
        db.open();
        Cursor c = db.getAllFoodOrders();
        if (c.moveToFirst()) {
            db.deleteFoodOrdered(1);
        }
        db.close();
    }

    private void clearDB() {
        db.open();
        db.clearDB();
        db.close();
    }

    private void DisplayFoodOrdered(Cursor c) {
        DisplayToast("customer_name: " + c.getString(0) + "\n" +
                "customer_address:  " + c.getString(1) + "\n" +
                "customer_city: " + c.getString(2) + "\n" +
                "customer_state: " + c.getString(3) + "\n" +
                "customer_zip: " + c.getString(4) + "\n" +
                "card_number: " + c.getString(5) + "\n" +
                "card_expiry: " + c.getString(6) + "\n" +
                "card_pin: " + c.getString(7) + "\n" +
                "total_items: " + c.getString(8) + "\n" +
                "subtotal: " + c.getString(9) + "\n" +
                "delivery_charge: " + c.getString(10) + "\n" +
                "total: " + c.getString(11));
    }

    private void DisplayToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

}