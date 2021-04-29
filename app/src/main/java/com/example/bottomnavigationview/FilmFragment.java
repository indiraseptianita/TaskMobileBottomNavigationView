package com.example.bottomnavigationview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FilmFragment extends Fragment {

    private RecyclerView recyclerView;
    private FilmAdapter adapter;
    private DatabaseFilm databases;

    public void onClick(FilmModel filmModel) {
        Intent detailActivity = new Intent(getContext(), DetailFilm.class);
        detailActivity.putExtra("FILM_DETAIL", filmModel);
        startActivity(detailActivity);
    }
    
    public static FilmFragment newInstance() {
        FilmFragment fragment = new FilmFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_film, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_film);
        databases = new DatabaseFilm(getContext());
        adapter = new FilmAdapter();
        adapter.setClickListener(this::onClick);
        adapter.setFilms(databases.getFilm());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
}