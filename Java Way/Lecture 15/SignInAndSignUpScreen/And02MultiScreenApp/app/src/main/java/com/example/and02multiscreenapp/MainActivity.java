package com.example.and02multiscreenapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText order1, order2, order3, order4;
    Button btnOrder;
    public static final String KEY = "com.example.and02multiscreenapp";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Linking UI with Java
        order1 = findViewById(R.id.editTextText);
        order2 = findViewById(R.id.editTextText2);
        order3 = findViewById(R.id.editTextText3);
        order4 = findViewById(R.id.editTextText4);
        btnOrder = findViewById(R.id.button);

        // Button Click Event
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String o1 = order1.getText().toString();
                String o2 = order2.getText().toString();
                String o3 = order3.getText().toString();
                String o4 = order4.getText().toString();

                String ordersPlaced = order1.getText().toString() + " " +
                        order2.getText().toString() + " " +
                        order3.getText().toString() + " " +
                        order4.getText().toString();

                Intent intent = new Intent(MainActivity.this, Order.class);
                intent.putExtra(KEY, ordersPlaced);
                startActivity(intent);
            }

        });
    }
}