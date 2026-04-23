package com.example.iistviewwithprojectone;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList<String> taskList = new ArrayList<>();
        taskList.add("Visit CP Hanuman Mandir");
        taskList.add("Attend Exam");
        taskList.add("Complete the App Dev Project");
        taskList.add("Buy bhindi from market");
        taskList.add("Work on resume");
        taskList.add("Improve internet presence");

        ArrayAdapter<String> adapterForMyListView =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);

        listView.setAdapter(adapterForMyListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String text = "Clicked on item : " + ((TextView) view).getText().toString();

                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }
}