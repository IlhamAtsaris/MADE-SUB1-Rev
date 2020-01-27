package com.assosiate.atsaris.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String title;
    private String description;
    private String tomato_meter;
    private String genres;
    private String audience_score;
    private String runtime;
    private String release_date;
    private String directedby;

    private int poster;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTomato_meter() {
        return tomato_meter;
    }

    public void setTomato_meter(String tomato_meter) {
        this.tomato_meter = tomato_meter;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getAudience_score() {
        return audience_score;
    }

    public void setAudience_score(String audience_score) {
        this.audience_score = audience_score;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getDirectedby() {
        return directedby;
    }

    public void setDirectedby(String directedby) {
        this.directedby = directedby;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public Movie() {
    }


    private Movie(Parcel in) {
        title = in.readString();
        description = in.readString();
        tomato_meter = in.readString();
        genres = in.readString();
        audience_score = in.readString();
        runtime = in.readString();
        release_date = in.readString();
        directedby = in.readString();
        poster = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(tomato_meter);
        dest.writeString(genres);
        dest.writeString(audience_score);
        dest.writeString(runtime);
        dest.writeString(release_date);
        dest.writeString(directedby);
        dest.writeInt(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };


}
