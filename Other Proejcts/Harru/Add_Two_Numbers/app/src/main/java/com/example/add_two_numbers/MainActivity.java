package com.example.add_two_numbers;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btn;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connect XML with Java
        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        btn = findViewById(R.id.buttonCalculate);
        result = findViewById(R.id.textResult);

        // button click
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get values
                String n1 = num1.getText().toString();
                String n2 = num2.getText().toString();

                // check empty
                if(n1.isEmpty() || n2.isEmpty()){
                    result.setText("Enter both numbers");
                    return;
                }

                // convert to int
                int a = Integer.parseInt(n1);
                int b = Integer.parseInt(n2);

                // calculate sum
                int sum = a + b;

                // show result
                result.setText(String.valueOf(sum));
            }
        });
    }
}