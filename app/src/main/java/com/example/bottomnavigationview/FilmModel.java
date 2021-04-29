package com.example.bottomnavigationview;

import android.os.Parcel;
import android.os.Parcelable;

public class FilmModel implements Parcelable {
    private String titleFilm;
    private String genreFilm;
    private int photoFilm;

    protected FilmModel(Parcel in) {
        photoFilm = in.readInt();
        titleFilm = in.readString();
        genreFilm = in.readString();
    }

    public static final Creator<FilmModel> CREATOR = new Creator<FilmModel>() {
        @Override
        public FilmModel createFromParcel(Parcel source) {
            return new FilmModel(source);
        }

        @Override
        public FilmModel[] newArray(int size) {
            return new FilmModel[size];
        }
    };

    public FilmModel() {}

    public String getTitleFilm() {
        return titleFilm;
    }

    public void setTitleFilm(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public String getGenreFilm() {
        return genreFilm;
    }

    public void setGenreFilm(String genreFilm) {
        this.genreFilm = genreFilm;
    }

    public int getPhotoFilm() {
        return photoFilm;
    }

    public void setPhotoFilm(int photoFilm) {
        this.photoFilm = photoFilm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photoFilm);
        dest.writeString(titleFilm);
        dest.writeString(genreFilm);
    }
}
