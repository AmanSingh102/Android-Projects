package com.example.fragments;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.fragments.ui.login.LoginFragment;

public class MainActivity extends AppCompatActivity {

    Button buttonClock, buttonExam, buttonValidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonClock = findViewById(R.id.btnTime);
        buttonExam = findViewById(R.id.btnExam);
        buttonValidate = findViewById(R.id.btnValidate);

        // Default fragment (optional)
        replaceFragment(new Clock_Fragment());

        // Clock Button Click
        buttonClock.setOnClickListener(v -> {
            replaceFragment(new Clock_Fragment());
        });

        // Exam Button Click
        buttonExam.setOnClickListener(v -> {
            replaceFragment(new Exam_Fragment());
        });

        buttonValidate.setOnClickListener(v -> {
            replaceFragment(new LoginFragment());
        });
    }

    // Fragment Replace Method
    private void replaceFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}