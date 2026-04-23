package com.example.readorusethedata;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignInActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    public static final String KEY1 = "com.example.readorusethedata.SignInActivity.mail";
    public static final String KEY2 = "com.example.readorusethedata.SignInActivity.name";
    public static final String KEY3 = "com.example.readorusethedata.SignInActivity.id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button signInButton = findViewById(R.id.btnSignIn);
        TextInputEditText userName = findViewById(R.id.userNameEditText);

        signInButton.setOnClickListener(v -> {

            String uniqueId = userName.getText().toString();

            if (!uniqueId.isEmpty()) {
                readData(uniqueId);
            } else {
                Toast.makeText(SignInActivity.this, "Please enter user id", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void readData(String uniqueId) {

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        databaseReference.child(uniqueId).get().addOnSuccessListener(snapshot -> {

            // check user exists or not
            if (snapshot.exists()) {

                String email = snapshot.child("email").getValue(String.class);
                String name = snapshot.child("name").getValue(String.class);
                String userId = snapshot.child("uniqueId").getValue(String.class);

                Intent intentWelcome = new Intent(SignInActivity.this, WelcomeActivity.class);
                intentWelcome.putExtra(KEY1, email);
                intentWelcome.putExtra(KEY2, name);
                intentWelcome.putExtra(KEY3, userId);

                startActivity(intentWelcome);

            } else {
                Toast.makeText(SignInActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
            }

        }).addOnFailureListener(e -> {
            Toast.makeText(SignInActivity.this, "Failed, Error in DB", Toast.LENGTH_SHORT).show();
        });
    }
}