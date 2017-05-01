package com.alanturing.popularmovies.data.model;

import java.util.ArrayList;
import java.util.List;

public class Response {
    private List<MovieObject> results = new ArrayList<>();

    public List<MovieObject> getResults(){
        return results;}
}
