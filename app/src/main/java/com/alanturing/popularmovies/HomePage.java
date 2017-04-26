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
import com.facebook.stetho.Stetho;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomePage extends AppCompatActivity {
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
        //Specify an Adapter
        MoviePosterAdapter mMoviePosterAdapter = new MoviePosterAdapter(HomePage.this, getTestData());
        mRecyclerView.setAdapter(mMoviePosterAdapter);
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
                Toast.makeText(getBaseContext(), "You selected Highest Rated", Toast.LENGTH_SHORT).show();
                break;
            case R.id.group_filter_popular:
                Toast.makeText(getBaseContext(), "You selected Most popular", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //Test Data
    public List<MovieObject> getTestData() {
        List<MovieObject> movies = new ArrayList<>();
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        movies.add(new MovieObject("Hello"));
        return movies;
    }
}
