package com.example.tugas10_2018030;
import static android.content.ContentValues.TAG;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.tugas10_2018030.databinding.ActivityProfileBinding;

import android.view.MenuItem;


import androidx.annotation.NonNull;


import com.google.android.material.navigation.NavigationView;

public class ProfileActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;

    private ActivityProfileBinding binding;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    private SessionManager session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setup view binding
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dl = (DrawerLayout)findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this,dl,R.string.Open,R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(abdt);
        abdt.syncState();

        preferences = getSharedPreferences("AndroidHiveLogin", 0);
        editor = preferences.edit();
        session = new SessionManager(getApplicationContext());

        //action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_alarm){
                    Intent a = new Intent(ProfileActivity.this,
                            MainActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_hewan){
                    Intent a = new Intent(ProfileActivity.this,
                            DestinationActivity.class);
                    startActivity(a);
                }else if (id == R.id.nav_sql){
                    Intent a = new Intent(ProfileActivity.this,
                            MainActivity1.class);
                    startActivity(a);
                }else if (id == R.id.nav_profile){
                    Intent a = new Intent(ProfileActivity.this,
                            ProfileActivity.class);
                    startActivity(a);
                }
                else if (id == R.id.nav_api) {
                    Intent a = new Intent(ProfileActivity.this,
                            MainActivity2.class);
                    startActivity(a);
                }
                else if (id == R.id.nav_out) {

                        Intent a = new Intent(ProfileActivity.this,
                                MainActivity3.class);
                        session.setLogin(false);
                        startActivity(a);
                        finish();
                    }

                return true;
            }
        });
    }
    //action Bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }
}