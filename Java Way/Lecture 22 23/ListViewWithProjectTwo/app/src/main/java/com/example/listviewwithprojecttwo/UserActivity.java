package com.example.listviewwithprojecttwo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        String name = getIntent().getStringExtra("name");
        String phoneNumber = getIntent().getStringExtra("phone");
        int imageId = getIntent().getIntExtra("imageId", R.drawable.pic5);

        TextView nameTv = findViewById(R.id.tVName);
        TextView phoneTv = findViewById(R.id.tVPhone);
        CircleImageView image = findViewById(R.id.profile_image);

        nameTv.setText(name);
        phoneTv.setText(phoneNumber);
        image.setImageResource(imageId);
    }
}