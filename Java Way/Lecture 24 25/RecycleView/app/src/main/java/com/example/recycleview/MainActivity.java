package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myRecyclerView;
    ArrayList<News> newsArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        myRecyclerView = findViewById(R.id.recyclerView);

        int[] newsImageArray = {
                R.drawable.img1,
                R.drawable.img2,
                R.drawable.img3,
                R.drawable.img4,
                R.drawable.img5,
                R.drawable.img6
        };

        String[] newsHeadingArray = {
                "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
                "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
                "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
                "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
                "Belarusian leader Lukashenko visits China amid Ukraine tensions",
                "China rips new U.S. House committee on countering Beijing",
                "Largest gathering of Foreign Ministers hosted by any G20 presidency: Foreign Secretary Vinay Kwatra"
        };

        String[] newsContent = {
                getString(R.string.news_content),
                getString(R.string.news_content),
                getString(R.string.news_content),
                getString(R.string.news_content),
                getString(R.string.news_content),
                getString(R.string.news_content)
        };

        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        newsArrayList = new ArrayList<>();

        for (int i = 0; i < newsImageArray.length; i++) {
            News news = new News(
                    newsHeadingArray[i],
                    newsImageArray[i],
                    newsContent[i]
            );
            newsArrayList.add(news);
        }

        MyAdapter myAdapter = new MyAdapter(newsArrayList, this);
        myRecyclerView.setAdapter(myAdapter);

        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {
            @Override
            public void onItemClicking(int position) {

                Intent intent = new Intent(MainActivity.this, NewsDetailActivity.class);
                intent.putExtra("heading", newsArrayList.get(position).getNewsHeading());
                intent.putExtra("imageId", newsArrayList.get(position).getNewsImage());
                intent.putExtra("newscontent", newsArrayList.get(position).getNewsContent());

                startActivity(intent);
            }
        });
    }
}