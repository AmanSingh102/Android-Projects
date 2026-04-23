package com.example.viewbinding;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.viewbinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(v -> {

            if (binding.checkBox.isChecked()) {
                // Open a New Screen
                // Example:
                // Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // startActivity(intent);

            } else {
                binding.checkBox.setButtonTintList(
                        ColorStateList.valueOf(Color.RED)
                );

                Toast.makeText(MainActivity.this,
                        "Please accept the T&C",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}