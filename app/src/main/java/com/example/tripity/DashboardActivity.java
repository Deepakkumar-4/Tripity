package com.example.tripity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tripity.Fragments.HistoryFragment;
import com.example.tripity.Fragments.HomeFragment;
import com.example.tripity.Fragments.ProfileFragment;
import com.example.tripity.Fragments.ScannerFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_nav_bar);
        bottomNav.setOnNavigationItemSelectedListener(nav_lisntener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentContainer_bottom_nav,new HomeFragment())
                .commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener
            nav_lisntener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {

                case R.id.bottom_home:
                    selectedFragment = new HomeFragment();
                    break;
                case R.id.scanner:
                    selectedFragment = new ScannerFragment();
                    break;
                case R.id.bottom_history:
                    selectedFragment = new HistoryFragment();
                    break;
                case R.id.bottom_profile:
                    selectedFragment = new ProfileFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentContainer_bottom_nav,selectedFragment)
                    .commit();

            return true;

        }
    };

}