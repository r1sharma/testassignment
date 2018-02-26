package com.example.testassignment.model;

import java.util.ArrayList;

public class Movie {

private ArrayList<Detail> movie = new ArrayList<Detail>();

    public ArrayList<Detail> getMovie() {
        return movie;
    }

    public void setMovie(ArrayList<Detail> movie) {
        this.movie = movie;
    }
}
