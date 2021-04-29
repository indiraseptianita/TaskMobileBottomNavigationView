package com.example.bottomnavigationview;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class DatabaseFilm {
    private Context context;

    public DatabaseFilm(Context context){
        this.context = context;
    }

    public List<FilmModel> getFilm() {
        List<FilmModel> films = new ArrayList<>();
        TypedArray foto = context.getResources().obtainTypedArray(R.array.posterFilm);
        String[] title = context.getResources().getStringArray(R.array.titleFilm);
        String[] genre = context.getResources().getStringArray(R.array.genreFilm);
        for (int i = 0; i < title.length; i++) {
            FilmModel film = new FilmModel();
            film.setPhotoFilm(foto.getResourceId(i, -1));
            film.setTitleFilm(title[i]);
            film.setGenreFilm(genre[i]);
            films.add(film);
        }
        return films;
    }

}
