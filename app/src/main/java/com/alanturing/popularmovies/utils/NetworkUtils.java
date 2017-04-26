package com.alanturing.popularmovies.utils;

import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkUtils {
    final static String TMDB_BASE_URL = "https://api.themoviedb.org/3/discover/";
    final static String PARAM_QUERTY = "q";
    final static String PARAM_SORT = "sort";
    final static String SORT_BY = "sort";

    public static URL buildUrl(String tmdbSerachQuery, String apiKey) {
        Uri buildUri = Uri.parse(TMDB_BASE_URL).buildUpon()
                .appendQueryParameter(PARAM_QUERTY, tmdbSerachQuery)
                .appendQueryParameter(PARAM_SORT, SORT_BY)
                .build();
        URL url = null;
        try {
            url = new URL(buildUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }

}
