package com.example.customisealertbox;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // create a variable of type Dialog
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = findViewById(R.id.btnClick);

        dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialogue);

        Drawable drawable = getDrawable(R.drawable.bg_alert_box);
        if (dialog.getWindow() != null) {
            dialog.getWindow().setBackgroundDrawable(drawable);
        }

        // creating variable for the custom_dialogue.xml design
        Button buttonGood = dialog.findViewById(R.id.btnGood);
        Button buttonFeedback = dialog.findViewById(R.id.btnFeedback);

        buttonGood.setOnClickListener(v -> dialog.dismiss());

        buttonFeedback.setOnClickListener(v -> {
            // intents or Toast
        });

        myButton.setOnClickListener(v -> dialog.show());
    }
}