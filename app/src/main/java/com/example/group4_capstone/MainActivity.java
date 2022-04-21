package com.example.group4_capstone;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Map);

    }

    Profile profile = new Profile();
    Map map = new Map();
    Schedule schedule = new Schedule();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
       switch (item.getItemId()) {
           case R.id.Map:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragment , map).commit();
               return true;

           case R.id.Profile:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragment , profile).commit();
               return true;

           case R.id.Schedule:
               getSupportFragmentManager().beginTransaction().replace(R.id.flFragment , schedule).commit();
               return true;

       }
        return false;

    }

}