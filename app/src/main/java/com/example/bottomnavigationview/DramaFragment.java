package com.example.bottomnavigationview;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class DramaFragment extends Fragment {
    private RecyclerView recyclerView;
    private DramaAdapter adapter;
    private DatabaseDrama databases;

    public void onClick(DramaModel dModel) {
        Intent detailActivity = new Intent(getContext(), DetailDrama.class);
        detailActivity.putExtra("DRAMA_DETAIL", dModel);
        startActivity(detailActivity);
    }
    
    public static DramaFragment newInstance() {
        DramaFragment fragment = new DramaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drama, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_drama);
        databases = new DatabaseDrama(getContext());
        adapter = new DramaAdapter();
        adapter.setClickListener(this::onClick);
        adapter.setDramas(databases.getDrama());

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        return view;
    }
}