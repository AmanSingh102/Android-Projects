package com.example.bottomnavigationview;
    
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Hide ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        bottomView = findViewById(R.id.bottomNavigation);

        // Default fragment
        replaceWithFragment(new Home());

        bottomView.setOnItemSelectedListener(item -> {

            int id = item.getItemId();

            if (id == R.id.item1) {
                replaceWithFragment(new Home());
            } else if (id == R.id.item2) {
                replaceWithFragment(new Search());
            } else if (id == R.id.item3) {
                replaceWithFragment(new Profile());
            }

            return true;
        });
    }

    private void replaceWithFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}