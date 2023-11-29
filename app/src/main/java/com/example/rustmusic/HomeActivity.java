package com.example.rustmusic;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rustmusic.adapters.SongAdapter;
import com.example.rustmusic.model.Song;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    private RecyclerView recyclerView;
    private SongAdapter songAdapter;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Button buttonSelectSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        List<Song> songs = createDummySongs();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        songAdapter = new SongAdapter(songs);
        recyclerView.setAdapter(songAdapter);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle item navigasi di sini

                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    // Handle untuk Home
                    Log.d(TAG, "onNavigationItemSelected: Home selected");
                } else if (id == R.id.nav_search) {
                    // Handle untuk Search
                    Log.d(TAG, "onNavigationItemSelected: Search selected");
                } else if (id == R.id.nav_setting) {
                    // Handle untuk Setting
                    Log.d(TAG, "onNavigationItemSelected: Setting selected");
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        RelativeLayout mainContentLayout = findViewById(R.id.mainContentLayout);
        buttonSelectSongs = findViewById(R.id.buttonSelectSongs);

        buttonSelectSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Button selected");
                // Handle klik pada tombol pilih lagu di sini
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle untuk Home
            Log.d(TAG, "onOptionsItemSelected: Home selected");
        } else if (id == R.id.nav_search) {
            // Handle untuk Search
            Log.d(TAG, "onOptionsItemSelected: Search selected");
        } else if (id == R.id.nav_setting) {
            // Handle untuk Setting
            Log.d(TAG, "onOptionsItemSelected: Setting selected");
        }

        return super.onOptionsItemSelected(item);
        }


    @Override
    public void onBackPressed() {
        Log.d(TAG, "onBackPressed: Back pressed");
        super.onBackPressed();
    }

    private List<Song> createDummySongs() {
        return Song.createDummySongs();
    }
}
