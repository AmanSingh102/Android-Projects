package com.example.multilevelscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Order extends AppCompatActivity {

    TextView tVOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // connect TextView
        tVOrder = findViewById(R.id.tVOrder);

        // get data from intent
        String ordersOfCustomer = getIntent().getStringExtra(MainActivity.KEY);

        // set text
        tVOrder.setText("Order Placed " + ordersOfCustomer);
    }
}