package com.example.bottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener  {

    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv_main);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_item_film, FilmFragment.newInstance());
        fragmentMap.put(R.id.menu_item_drama, DramaFragment.newInstance());
        fragmentMap.put(R.id.menu_item_fav, FavoriteFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_item_film);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.menu_item_film:
                setActionBarTitle("Film");
                selectedFragment = new FilmFragment();
                break;
            case R.id.menu_item_drama:
                setActionBarTitle("Drama");
                selectedFragment = new DramaFragment();
                break;
            case R.id.menu_item_fav:
                setActionBarTitle("Favorite");
                selectedFragment = new FavoriteFragment();
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_main, selectedFragment).commit();

        return true;
    }

    private void setActionBarTitle(String nama) {
        getSupportActionBar().setTitle(nama);
    }
}