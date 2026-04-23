package com.example.dialoguebox;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dialoguebox.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // ---------------- BUTTON 1 ----------------
        binding.btn1.setOnClickListener(v -> {

            AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
            builder1.setTitle("Are you Sure?");
            builder1.setMessage("Do you want to close the App");
            builder1.setIcon(R.drawable.outline_exit_to_app_24);

            builder1.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish(); // close app
                }
            });

            builder1.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder1.show();
        });

        // ---------------- BUTTON 2 (Single Choice) ----------------
        binding.btn2.setOnClickListener(v -> {

            final String[] options = {"Gulab Jamun", "Rasmallai", "Kaju Katli"};

            AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
            builder2.setTitle("Which is your favourite sweet?");

            builder2.setSingleChoiceItems(options, 0, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,
                            "You clicked on " + options[which],
                            Toast.LENGTH_SHORT).show();
                }
            });

            builder2.setPositiveButton("Submit", null);

            builder2.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder2.show();
        });

        // ---------------- BUTTON 3 (Multi Choice) ----------------
        binding.btn3.setOnClickListener(v -> {

            final String[] options = {"Gulab Jamun", "Rasmallai", "Kaju Katli"};

            AlertDialog.Builder builder3 = new AlertDialog.Builder(MainActivity.this);
            builder3.setTitle("Which is your favourite sweet?");

            builder3.setMultiChoiceItems(options, null,
                    new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            Toast.makeText(MainActivity.this,
                                    "You clicked on " + options[which],
                                    Toast.LENGTH_SHORT).show();
                        }
                    });

            builder3.setPositiveButton("Submit", null);

            builder3.setNegativeButton("Decline", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            builder3.show();
        });
    }
}