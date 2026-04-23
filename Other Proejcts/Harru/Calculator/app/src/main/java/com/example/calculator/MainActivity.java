package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView result;
    Button add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextNumber1);
        num2 = findViewById(R.id.editTextNumber2);
        result = findViewById(R.id.textResult);

        add = findViewById(R.id.btnAdd);
        sub = findViewById(R.id.btnSub);
        mul = findViewById(R.id.btnMul);
        div = findViewById(R.id.btnDiv);

        // ADD
        add.setOnClickListener(v -> calculate("+"));

        // SUBTRACT
        sub.setOnClickListener(v -> calculate("-"));

        // MULTIPLY
        mul.setOnClickListener(v -> calculate("*"));

        // DIVIDE
        div.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String op) {

        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if(n1.isEmpty() || n2.isEmpty()){
            result.setText("Enter numbers");
            return;
        }

        double a = Double.parseDouble(n1);
        double b = Double.parseDouble(n2);
        double ans = 0;

        switch(op){
            case "+":
                ans = a + b;
                break;

            case "-":
                ans = a - b;
                break;

            case "*":
                ans = a * b;
                break;

            case "/":
                if(b == 0){
                    result.setText("Cannot divide by 0");
                    return;
                }
                ans = a / b;
                break;
        }

        result.setText(String.valueOf(ans));
    }
}