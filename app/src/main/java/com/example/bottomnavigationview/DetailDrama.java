package com.example.bottomnavigationview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailDrama extends AppCompatActivity {
    private TextView tvNamaF, tvGenreF;
    private ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_drama);
        tvNamaF = findViewById(R.id.tv_title_drama);
        tvGenreF = findViewById(R.id.tv_genre_drama);
        photo = findViewById(R.id.iv_poster_drama);

        DramaModel drama = getIntent().getParcelableExtra("DRAMA_DETAIL");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(drama.getTitle());
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
        DramaModel drama = getIntent().getParcelableExtra("DRAMA_DETAIL");
        System.out.println(drama.getTitle());
        photo.setImageResource(drama.getPhoto());
        tvNamaF.setText(drama.getTitle());
        tvGenreF.setText(drama.getGenre());
    }

}