package com.example.readorusethedata;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signButton = findViewById(R.id.btnSignUp);
        TextInputEditText etName = findViewById(R.id.etName);
        TextInputEditText etMail = findViewById(R.id.etMail);
        TextInputEditText userId = findViewById(R.id.etUserName);
        TextInputEditText userPassword = findViewById(R.id.etPassword);

        signButton.setOnClickListener(v -> {

            String name = etName.getText().toString();
            String mail = etMail.getText().toString();
            String uniqueId = userId.getText().toString();
            String password = userPassword.getText().toString();

            User user = new User(name, mail, password, uniqueId);

            database = FirebaseDatabase.getInstance().getReference("Users");

            database.child(uniqueId).setValue(user)
                    .addOnSuccessListener(unused -> {
                        etName.getText().clear();
                        etMail.getText().clear();
                        userId.getText().clear();
                        userPassword.getText().clear();
                        Toast.makeText(MainActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    });
        });

        TextView signIntext = findViewById(R.id.tvSignIN);
        signIntext.setOnClickListener(v -> {
            Intent openSignInActivity = new Intent(MainActivity.this, SignInActivity.class);
            startActivity(openSignInActivity);
        });

    }
}