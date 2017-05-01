package com.alanturing.popularmovies.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alanturing.popularmovies.R;
import com.alanturing.popularmovies.data.model.MovieObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.alanturing.popularmovies.utils.AppConstants.BASE_URL_PICTURE;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterViewHolder> {

    private List<MovieObject> movieObjectList;
    private Context context;

    //Constructor
    public MoviePosterAdapter(Context context, List<MovieObject> movieObjectList) {
        this.context = context;
        this.movieObjectList = movieObjectList;
    }

    @Override
    public MoviePosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.movie_poster, parent, false);
        return new MoviePosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviePosterViewHolder holder, int position) {
        MovieObject movieObject = movieObjectList.get(position);
        Picasso.with(context).load(BASE_URL_PICTURE + movieObject.getMoviePoster()).into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movieObjectList.size();
    }
}
