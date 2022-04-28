package com.example.group4_capstone;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    BottomNavigationView bottomNavigationView;
    TopBanner topbanner = new TopBanner();
    FloatingActionButton fabAlarm;

    Profile profile = new Profile();
    Map map = new Map();
    Schedule schedule = new Schedule();
    Settings settings = new Settings();
    Alarm alarmSet = new Alarm();

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

        //sets up bottom navigation and selects it on Map upon startup
        bottomNavigationView = findViewById(R.id.bottomNavigationView) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Map);

        //displays top banner information on startup
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentTopBanner, topbanner).commit();

        fabAlarm = findViewById(R.id.fabAlarm);

        fabAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragmentMain, alarmSet).commit();

                /* Intent intent = new Intent(MainActivity.this,Alarm.class);
                startActivity(intent); */
            }

        });


    }


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