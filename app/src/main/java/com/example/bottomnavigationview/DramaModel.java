package com.example.bottomnavigationview;

import android.os.Parcel;
import android.os.Parcelable;

public class DramaModel implements Parcelable {
    private String title;
    private String genre;
    private int photo;

    protected DramaModel(Parcel in) {
        photo = in.readInt();
        title = in.readString();
        genre = in.readString();
    }

    public static final Creator<DramaModel> CREATOR = new Creator<DramaModel>() {
        @Override
        public DramaModel createFromParcel(Parcel source) {
            return new DramaModel(source);
        }

        @Override
        public DramaModel[] newArray(int size) {
            return new DramaModel[size];
        }
    };

    public DramaModel() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(title);
        dest.writeString(genre);
    }
}
