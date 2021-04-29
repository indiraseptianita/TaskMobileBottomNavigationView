package com.example.bottomnavigationview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private List<FilmModel> films;
    private OnItemClickListener<FilmModel> clickListener;

    public void setFilms(List<FilmModel> films) {this.films = films;}

    public void setClickListener(OnItemClickListener<FilmModel> clickListener){
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        FilmModel film;
        ImageView ivPhoto;
        TextView tvName, tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPhoto = itemView.findViewById(R.id.iv_film);
            tvName = itemView.findViewById(R.id.tv_filmT);
            tvGenre = itemView.findViewById(R.id.tv_filmG);
        }

        public void onBind(FilmModel film) {
            this.film = film;
            ivPhoto.setImageResource(film.getPhotoFilm());
            tvName.setText(film.getTitleFilm());
            tvGenre.setText(film.getGenreFilm());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(film);
        }
    }

}
