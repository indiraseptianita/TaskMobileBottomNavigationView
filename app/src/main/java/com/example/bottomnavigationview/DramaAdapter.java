package com.example.bottomnavigationview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DramaAdapter extends RecyclerView.Adapter<DramaAdapter.ViewHolder> {
    private List<DramaModel> dramas;
    private OnItemClickListener<DramaModel> clickListener;

    public void setDramas(List<DramaModel> dramas) {this.dramas = dramas;}

    public void setClickListener(OnItemClickListener<DramaModel> clickListener){
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_drama, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(dramas.get(position));
    }

    @Override
    public int getItemCount() {
        return dramas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        DramaModel drama;
        ImageView ivPhoto;
        TextView tvName, tvGenre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ivPhoto = itemView.findViewById(R.id.iv_drama);
            tvName = itemView.findViewById(R.id.tv_dramaT);
            tvGenre = itemView.findViewById(R.id.tv_dramaG);
        }

        public void onBind(DramaModel drama) {
            this.drama = drama;
            ivPhoto.setImageResource(drama.getPhoto());
            tvName.setText(drama.getTitle());
            tvGenre.setText(drama.getGenre());
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(drama);
        }
    }

}
