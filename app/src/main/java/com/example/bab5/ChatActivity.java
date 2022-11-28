package com.example.bab5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.bab5.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class ChatActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(MyWorker.class).build();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WorkManager.getInstance().enqueueUniqueWork("Notifikasi", ExistingWorkPolicy.REPLACE, request);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    Intent a = new Intent(ChatActivity.this, MainActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_notif) {
                    Intent a = new Intent(ChatActivity.this, ChatActivity.class);
                    startActivity(a);
                } else if (id == R.id.nav_profile) {
                    Intent a = new Intent(ChatActivity.this, MainActivity3.class);
                    startActivity(a);
                }else if (id == R.id.nav_chat) {
                    Intent a = new Intent(ChatActivity.this, MainActivity2.class);
                    startActivity(a);
                }
                return true;
            }
        });
    }
}