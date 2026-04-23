package com.example.multilevelscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // creating key
    public static final String KEY = "com.example.day13.MainActivity.KEY";

    EditText eT1, eT2, eT3, eT4;
    Button btnOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect UI
        eT1 = findViewById(R.id.eT1);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
        eT4 = findViewById(R.id.eT4);
        btnOrder = findViewById(R.id.btnOrder);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String ordersPlaced =
                        eT1.getText().toString() + " " +
                                eT2.getText().toString() + " " +
                                eT3.getText().toString() + " " +
                                eT4.getText().toString();

                Intent intent = new Intent(MainActivity.this, Order.class);
                intent.putExtra(KEY, ordersPlaced);
                startActivity(intent);
            }
        });
    }
}