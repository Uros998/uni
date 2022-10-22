package com.metropolitan.foodorderapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.metropolitan.foodorderapp.adapter.DBAdapter;
import com.metropolitan.foodorderapp.adapter.MenuListAdapter;
import com.metropolitan.foodorderapp.adapter.PlaceYourOrderAdapter;
import com.metropolitan.foodorderapp.model.Menu;
import com.metropolitan.foodorderapp.model.RestaurantModel;

public class PlaceYourOrderActivity extends AppCompatActivity {

    static DBAdapter db;

    private EditText inputName, inputAddress, inputCity, inputState, inputZip, inputCardNumber, inputCardExpiry, inputCardPin;
    private RecyclerView cartItemsRecyclerView;
    private TextView subTotalAmount, deliveryCharge, deliveryChargeAmount, totalAmount, buttonPlaceYourOrder;
    private SwitchCompat switchDelivery;
    private boolean isDeliveryOn;
    private PlaceYourOrderAdapter placeYourOrderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_your_order);

        db = new DBAdapter(this);

        RestaurantModel restaurantModel = getIntent().getParcelableExtra("RestaurantModel");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(restaurantModel.getName());
        actionBar.setSubtitle(restaurantModel.getAddress());
        actionBar.setDisplayHomeAsUpEnabled(true);

        inputName = findViewById(R.id.inputName);
        inputAddress = findViewById(R.id.inputAddress);
        inputCity = findViewById(R.id.inputCity);
        inputState = findViewById(R.id.inputState);
        inputZip = findViewById(R.id.inputZip);
        inputCardNumber = findViewById(R.id.inputCardNumber);
        inputCardExpiry = findViewById(R.id.inputCardExpiry);
        inputCardPin = findViewById(R.id.inputCardPin);

        cartItemsRecyclerView = findViewById(R.id.cartItemsRecyclerView);

        subTotalAmount = findViewById(R.id.subTotalAmount);
        deliveryCharge = findViewById(R.id.deliveryCharge);
        deliveryChargeAmount = findViewById(R.id.deliveryChargeAmount);
        totalAmount = findViewById(R.id.totalAmount);
        buttonPlaceYourOrder = findViewById(R.id.buttonPlaceYourOrder);

        switchDelivery = findViewById(R.id.switchDelivery);

        buttonPlaceYourOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onPlaceOrderButtonClick(restaurantModel);
            }
        });

        switchDelivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    inputAddress.setVisibility(View.VISIBLE);
                    inputCity.setVisibility(View.VISIBLE);
                    inputState.setVisibility(View.VISIBLE);
                    inputZip.setVisibility(View.VISIBLE);
                    deliveryCharge.setVisibility(View.VISIBLE);
                    deliveryChargeAmount.setVisibility(View.VISIBLE);
                    isDeliveryOn = true;
                    calculateTotalAmount(restaurantModel);
                } else {
                    inputAddress.setVisibility(View.GONE);
                    inputCity.setVisibility(View.GONE);
                    inputState.setVisibility(View.GONE);
                    inputZip.setVisibility(View.GONE);
                    deliveryCharge.setVisibility(View.GONE);
                    deliveryChargeAmount.setVisibility(View.GONE);
                    isDeliveryOn = false;
                    calculateTotalAmount(restaurantModel);
                }
            }
        });
        initRecyclerView(restaurantModel);
        calculateTotalAmount(restaurantModel);
    }

    private void calculateTotalAmount(RestaurantModel restaurantModel) {
        float amount = 0f;
        for (Menu m : restaurantModel.getMenuList()) {
            amount += m.getTotalInCart() * m.getPrice();
        }

        subTotalAmount.setText("$" + String.format("%.2f", amount));

        if (isDeliveryOn == true) {
            deliveryChargeAmount.setText("$" + String.format("%.2f", restaurantModel.getDelivery_charge()));
            amount += restaurantModel.getDelivery_charge();
        }

        totalAmount.setText("$" + String.format("%.2f", amount));
    }

    private void onPlaceOrderButtonClick(RestaurantModel restaurantModel) {
        if (TextUtils.isEmpty(inputName.getText().toString())) {
            inputName.setError("Please enter name ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputAddress.getText().toString())) {
            inputAddress.setError("Please enter address ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputCity.getText().toString())) {
            inputCity.setError("Please enter city ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputState.getText().toString())) {
            inputState.setError("Please enter state ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputZip.getText().toString())) {
            inputZip.setError("Please enter zip ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputCardNumber.getText().toString())) {
            inputCardNumber.setError("Please enter card number ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputCardExpiry.getText().toString())) {
            inputCardExpiry.setError("Please enter card expiry ");
            return;
        } else if (isDeliveryOn == true && TextUtils.isEmpty(inputCardPin.getText().toString())) {
            inputCardPin.setError("Please enter card pin/cvv ");
            return;
        }

        Intent i = new Intent(PlaceYourOrderActivity.this, OrderSuccessActivity.class);
        i.putExtra("RestaurantModel", restaurantModel);
        startActivityForResult(i, 1000);

        insertIntoDB(inputName.getText().toString(), inputAddress.getText().toString(), inputCity.getText().toString(), inputState.getText().toString(), inputZip.getText().toString(), inputCardNumber.getText().toString(), inputCardExpiry.getText().toString(), inputCardPin.getText().toString(), restaurantModel.getMenuList().size(), subTotalAmount.getText().toString(), deliveryChargeAmount.getText().toString(), totalAmount.getText().toString());
    }

    private void initRecyclerView(RestaurantModel restaurantModel) {
        cartItemsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        placeYourOrderAdapter = new PlaceYourOrderAdapter(restaurantModel.getMenuList());
        cartItemsRecyclerView.setAdapter(placeYourOrderAdapter);
    }

    private void insertIntoDB(String inputName, String inputAddress, String inputCity, String inputState, String inputZip, String inputCardNumber, String inputCardExpiry, String inputCardPin, int totalItems, String subTotalAmount, String deliveryChargeAmount, String totalAmount) {
        if (inputZip.equals("")) {
            inputZip = "0";
        }

        db.open();
        long id = db.insertFoodOrder(inputName, inputAddress, inputCity, inputState, Integer.parseInt(inputZip), inputCardNumber, Integer.parseInt(inputCardExpiry), Integer.parseInt(inputCardPin), totalItems, subTotalAmount, deliveryChargeAmount, totalAmount);
        db.close();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1000) {
            setResult(Activity.RESULT_OK);
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
            default:
                //
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(Activity.RESULT_CANCELED);
        finish();
    }

}