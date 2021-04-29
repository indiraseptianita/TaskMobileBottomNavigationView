package com.example.bottomnavigationview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailFilm extends AppCompatActivity {
    private TextView tvNamaF, tvGenreF;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvNamaF = findViewById(R.id.tv_title_film);
        tvGenreF = findViewById(R.id.tv_genre_film);
        photo = findViewById(R.id.iv_poster_film);

        FilmModel film = getIntent().getParcelableExtra("FILM_DETAIL");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(film.getTitleFilm());
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FilmModel film = getIntent().getParcelableExtra("FILM_DETAIL");
        System.out.println(film.getTitleFilm());
        photo.setImageResource(film.getPhotoFilm());
        tvNamaF.setText(film.getTitleFilm());
        tvGenreF.setText(film.getGenreFilm());
    }

}