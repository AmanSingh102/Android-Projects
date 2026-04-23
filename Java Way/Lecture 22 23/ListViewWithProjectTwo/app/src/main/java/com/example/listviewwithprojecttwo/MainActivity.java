package com.example.listviewwithprojecttwo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> userArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] name = {"Saumya", "Prastuti", "Ankit", "Pradeep", "Aman"};

        String[] lastMsg = {"Hey everyone", "I am fine", "Good", "Awesome", "cool"};

        String[] lastMsgTime = {"6:25 AM", "7:30 PM", "5:00 PM", "6:25 AM", "7:30 PM"};

        String[] phoneNumber = {"786453739", "986453739", "7366382829", "7383413440", "4159251517"};

        int[] imgId = {
                R.drawable.pic5,
                R.drawable.pic1,
                R.drawable.pic2,
                R.drawable.pic3,
                R.drawable.pic4
        };

        userArrayList = new ArrayList<>();

        for (int i = 0; i < name.length; i++) {
            User user = new User(
                    name[i],
                    lastMsg[i],
                    lastMsgTime[i],
                    phoneNumber[i],
                    imgId[i]
            );
            userArrayList.add(user);
        }

        ListView listView = findViewById(R.id.listView);
        listView.setClickable(true);
        listView.setAdapter(new MyAdapter(this, userArrayList));

        listView.setOnItemClickListener((parent, view, position, id) -> {

            String userName = name[position];
            String userPhone = phoneNumber[position];
            int imageId = imgId[position];

            Intent i1 = new Intent(MainActivity.this, UserActivity.class);

            i1.putExtra("name", userName);
            i1.putExtra("phone", userPhone);
            i1.putExtra("imageId", imageId);

            startActivity(i1);
        });
    }
}