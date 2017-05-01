package com.alanturing.popularmovies.data.model;

import android.widget.ImageView;

public class MovieObject {
    private String id;
    private String original_title;
    private String poster_path;
    private String overview;
    private String vote_average;
    private String release_date;

    //region Getters
    public String getId() {
        return id;
    }

    public String getOriginalTitle() {
        return original_title;
    }

    public String getMoviePoster() {
        return poster_path;
    }

    public String getOverview() {

        return overview;
    }

    public String getVoteAverage() {

        return vote_average;
    }

    public String getReleaseDate() {

        return release_date;
    }
//endregion
}
