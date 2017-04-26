package com.alanturing.popularmovies.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.alanturing.popularmovies.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//Provide a reference to the views for each data item
//You provide access to all the views for a data item in a view holder
public class MoviePosterViewHolder extends RecyclerView.ViewHolder{
    @BindView(R.id.iv_poster) public ImageView moviePoster;
    public MoviePosterViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
