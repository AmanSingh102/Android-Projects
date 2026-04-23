package com.example.readorusethedata;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String name = getIntent().getStringExtra(SignInActivity.KEY2);
        String mail = getIntent().getStringExtra(SignInActivity.KEY1);
        String userId = getIntent().getStringExtra(SignInActivity.KEY3);

        TextView welcomeText = findViewById(R.id.tVWelcome);
        TextView mailText = findViewById(R.id.tvMail);
        TextView idText = findViewById(R.id.tvUnique);

        welcomeText.setText("Welcome " + name);
        mailText.setText("Mail : " + mail);
        idText.setText("UserId : " + userId);
    }
}