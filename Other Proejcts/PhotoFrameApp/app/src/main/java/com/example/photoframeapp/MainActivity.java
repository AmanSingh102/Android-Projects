package com.example.photoframeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int currentImage = 0;
    ImageView image;
    TextView text;

    String[] names = {"Lana Rhoades", "Dani Daniels", "Riley Reid", "Molly Little", "Lena Anderson", "Melena", "Marta E", "Liv", "Ellie Nova", "Stella Cox"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        ImageButton prev = findViewById(R.id.imgPrev);
        ImageButton next = findViewById(R.id.imgNext);
        text = findViewById(R.id.textView);

        prev.setOnClickListener(v -> changeImage(-1));
        next.setOnClickListener(v -> changeImage(1));
    }

    // 🔥 Reusable function
    private void changeImage(int direction) {

        // hide current image
        int currentId = getResources().getIdentifier("pic" + currentImage, "id", getPackageName());
        image = findViewById(currentId);
        image.setAlpha(0f);

        // change index
        currentImage = (names.length + currentImage + direction) % names.length;

        // show new image
        int newId = getResources().getIdentifier("pic" + currentImage, "id", getPackageName());
        image = findViewById(newId);
        image.setAlpha(1f);

        // update text
        text.setText(names[currentImage]);
    }
}