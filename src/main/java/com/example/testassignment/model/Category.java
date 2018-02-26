package com.example.testassignment.model;

import java.util.ArrayList;

public class Category {
    private ArrayList<Movie> typeofShow;

    public ArrayList<Movie> getTypeofShow() {
        return typeofShow;
    }

    public void setTypeofShow(ArrayList<Movie> typeofShow) {
        this.typeofShow = typeofShow;
    }

    @Override
    public String toString() {
        return "Category{" +
                "typeofShow=" + typeofShow +
                '}';
    }
}
