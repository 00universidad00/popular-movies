package com.alanturing.popularmovies.data.model;

import android.widget.ImageView;

public class MovieObject {
    private String movieName;
    private ImageView moviePoster;

    public MovieObject(String movieName /* TODO(2) Enable ImageView moviePoster*/) {
        this.movieName = movieName;
        //TODO(1) this.moviePoster = moviePoster;
    }

    public String getMovieName() {
        return movieName;
    }

    public ImageView getMoviePoster() {
        return moviePoster;
    }
}
