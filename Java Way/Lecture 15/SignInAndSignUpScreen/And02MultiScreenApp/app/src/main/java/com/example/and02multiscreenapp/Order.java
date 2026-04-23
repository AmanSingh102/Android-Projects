package com.example.and02multiscreenapp;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Order extends AppCompatActivity {

    TextView tVOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        tVOrder = findViewById(R.id.tvOrder);
        String ordersOfCustomer = getIntent().getStringExtra(MainActivity.KEY);
        tVOrder.setText("Order placed : " + ordersOfCustomer);
    }
}