package com.example.photoframeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int currentImage = 0;
    ImageView image;
    String[] names = {"Virat Kohli", "Saumya Singh", "Malala", "Priyanka Chopra"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageButton prev = findViewById(R.id.imgPrev);
        ImageButton next = findViewById(R.id.imgNext);
        TextView text = findViewById(R.id.textView);

        prev.setOnClickListener(v -> {
            String idCurrentImageString = "pic" + currentImage;

            int idCurrentImageInt = getResources().getIdentifier(idCurrentImageString, "id", getPackageName());

            image = findViewById(idCurrentImageInt);
            image.setAlpha(0f);

            currentImage = (4 + currentImage - 1) % 4;

            String idImageToShowString = "pic" + currentImage;

            int idImageToShowInt = getResources().getIdentifier(idImageToShowString, "id", getPackageName());

            image = findViewById(idImageToShowInt);
            image.setAlpha(1f);

            text.setText(names[currentImage]);
        });

        next.setOnClickListener(v -> {
            String idCurrentImageString = "pic" + currentImage;

            int idCurrentImageInt = getResources().getIdentifier(idCurrentImageString, "id", getPackageName());

            image = findViewById(idCurrentImageInt);
            image.setAlpha(0f);

            currentImage = (4 + currentImage + 1) % 4;

            String idImageToShowString = "pic" + currentImage;

            int idImageToShowInt = getResources().getIdentifier(idImageToShowString, "id", getPackageName());

            image = findViewById(idImageToShowInt);
            image.setAlpha(1f);

            text.setText(names[currentImage]);
        });
    }
}