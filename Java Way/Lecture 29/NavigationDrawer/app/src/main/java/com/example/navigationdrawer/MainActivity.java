package com.example.navigationdrawer;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    MaterialToolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);

        // FloatingActionButton click
        fab.setOnClickListener(v -> {
            Snackbar.make(v,
                    "Message button clicked",
                    Snackbar.LENGTH_SHORT).show();
        });

        // Drawer toggle
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Default fragment
        loadFragment(new HomeFragment(), "Home");

        // Navigation menu click
        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            String title = "";

            int id = item.getItemId();

            if (id == R.id.nav_home) {
                fragment = new HomeFragment();
                title = "Home";
            } else if (id == R.id.nav_gallery) {
                fragment = new GalleryFragment();
                title = "Gallery";
            } else if (id == R.id.nav_slideshow) {
                fragment = new SlideshowFragment();
                title = "Slideshow";
            }

            if (fragment != null) {
                loadFragment(fragment, title);
            }

            drawerLayout.closeDrawers();
            return true;
        });
    }

    private void loadFragment(Fragment fragment, String title) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

        toolbar.setTitle(title);
    }
}