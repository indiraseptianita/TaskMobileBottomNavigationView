package com.example.bottomnavigationview;

import android.content.Context;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDrama {
    private Context context;

    public DatabaseDrama(Context context){
        this.context = context;
    }

    public List<DramaModel> getDrama() {
        List<DramaModel> dramas = new ArrayList<>();
        TypedArray fotoD = context.getResources().obtainTypedArray(R.array.posterDrama);
        String[] name = context.getResources().getStringArray(R.array.titleDrama);
        String[] genre = context.getResources().getStringArray(R.array.genreDrama);
        for (int i = 0; i < name.length; i++) {
            DramaModel drama = new DramaModel();
            drama.setPhoto(fotoD.getResourceId(i, -1));
            drama.setTitle(name[i]);
            drama.setGenre(genre[i]);
            dramas.add(drama);
        }
        return dramas;
    }

}
