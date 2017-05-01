package com.alanturing.popularmovies.utils;

public class AppConstants {
    public static final String KEY_API = "";

    // Pictures size w185
    // TODO Move to Utils URL
    public static final String BASE_URL_PICTURE = "http://image.tmdb.org/t/p/w342/";
    public static final String URL_DISCOVER = "https://api.themoviedb.org/3/discover/movie?sort_by=popularty.desc&api_key=" + KEY_API;
    public static final String URL_MOST_POPULAR = "https://api.themoviedb.org/3/movie/popular?api_key=" + KEY_API;
    public static final String URL_TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + KEY_API;


    private AppConstants() {
        // This utility class is not publicly instantiable
    }
}
