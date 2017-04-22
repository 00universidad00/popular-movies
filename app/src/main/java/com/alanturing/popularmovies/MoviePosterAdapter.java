package com.alanturing.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alanturing.popularmovies.data.model.MovieObject;

import java.util.List;

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterViewHolder> {
    private static final String TAG = MoviePosterAdapter.class.getSimpleName();
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
        //TODO (1) change hardcoded image
        holder.moviePoster.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    public int getItemCount() {
        return movieObjectList.size();
    }
}
