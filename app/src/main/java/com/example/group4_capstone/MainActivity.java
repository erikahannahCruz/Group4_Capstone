package com.example.group4_capstone;

import android.os.Bundle;
import android.view.MenuItem;


import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    TopBanner topbanner = new TopBanner();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hide Action Bar
        try {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e) {
        }

        bottomNavigationView = findViewById(R.id.bottomNavigationView) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Map);

        //displays top banner information on startup
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentTopBanner, topbanner).commit();

    }

    Profile profile = new Profile();
    Map map = new Map();
    Schedule schedule = new Schedule();
    Settings settings = new Settings();


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()) {
           case R.id.Map:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentMain, map).commit();
               return true;

           case R.id.Profile:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentMain, profile).commit();
               return true;

           case R.id.Schedule:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentMain, schedule).commit();
               return true;

           case R.id.Settings:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentMain, settings).commit();
               return true;

       }
        return false;
    }

}