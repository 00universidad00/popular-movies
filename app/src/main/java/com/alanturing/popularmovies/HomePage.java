package com.alanturing.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.alanturing.popularmovies.data.model.MovieObject;
import com.alanturing.popularmovies.ui.MoviePosterAdapter;
import com.alanturing.popularmovies.utils.LoadJSONTask;
import com.facebook.stetho.Stetho;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.alanturing.popularmovies.utils.AppConstants.URL_DISCOVER;
import static com.alanturing.popularmovies.utils.AppConstants.URL_MOST_POPULAR;
import static com.alanturing.popularmovies.utils.AppConstants.URL_TOP_RATED;

public class HomePage extends AppCompatActivity implements LoadJSONTask.Listener {
    private static final String TAG = HomePage.class.getSimpleName();
    @BindView(R.id.rv_gallery)
    RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //Enable Butter Knife Injection
        ButterKnife.bind(this);
        //Enable Stetho Integration
        Stetho.initializeWithDefaults(this);
        //Changes in content do not change the layout size of RecyclerView
        mRecyclerView.setHasFixedSize(true);
        //Use a grid layout manager
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        // Get JSON from Internet
        new LoadJSONTask(this).execute(URL_DISCOVER);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_page, menu);
        return true;
    }

    public void onActionFilterClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.group_filter_highest:
                new LoadJSONTask(this).execute(URL_TOP_RATED);
                Toast.makeText(getBaseContext(), getString(R.string.toast_highest_rated), Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_filter_popular:
                new LoadJSONTask(this).execute(URL_MOST_POPULAR);
                Toast.makeText(getBaseContext(), getString(R.string.toast_most_popular), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onLoaded(List<MovieObject> movieList) {
        MoviePosterAdapter mMoviePosterAdapter = new MoviePosterAdapter(HomePage.this, movieList);
        mRecyclerView.setAdapter(mMoviePosterAdapter);
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }

}
