package com.example.bab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle abdt;

    RecyclerView recylerView;

    String s1[], s2[], s3[];
    int images[] = {R.drawable.bleach, R.drawable.inu, R.drawable.dragon, R.drawable.naruto};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = (DrawerLayout) findViewById(R.id.dl);
        abdt = new ActionBarDrawerToggle(this, drawer, R.string.Open, R.string.Close);
        abdt.setDrawerIndicatorEnabled(true);

        drawer.addDrawerListener(abdt);
        abdt.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    Intent a = new Intent(MainActivity.this,
                            MainActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_notif) {
                    Intent a = new Intent(MainActivity.this,
                            ChatActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_chat) {
                    Intent a = new Intent(MainActivity.this,
                            MainActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_profile) {
                    Intent a = new Intent(MainActivity.this,
                            MainActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_alarm) {
                    Intent a = new Intent(MainActivity.this,
                            MainActivity3.class);
                    startActivity(a);
                }

                return true;
            }
        });
        recylerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.produk);
        s2 = getResources().getStringArray(R.array.star);
        s3 = getResources().getStringArray(R.array.harga);

        KomikAdapter appAdapter = new KomikAdapter(this, s1, s2, s3, images);
        recylerView.setAdapter(appAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager((this), RecyclerView.HORIZONTAL, false);
        recylerView.setLayoutManager(layoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return abdt.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }
}