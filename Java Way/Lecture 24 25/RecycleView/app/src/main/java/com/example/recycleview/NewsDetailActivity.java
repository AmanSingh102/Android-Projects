package com.example.recycleview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        String heading = getIntent().getStringExtra("heading");
        String newsContent = getIntent().getStringExtra("newscontent");
        int imageId = getIntent().getIntExtra("imageId", R.drawable.img1);

        TextView headingTV = findViewById(R.id.newsHeading);
        ImageView headingIV = findViewById(R.id.newsImage);
        TextView newsContentTV = findViewById(R.id.newsContent);

        headingTV.setText(heading);
        newsContentTV.setText(newsContent);
        headingIV.setImageResource(imageId);
    }
}