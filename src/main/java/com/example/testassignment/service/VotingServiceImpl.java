package com.example.testassignment.service;

import com.example.testassignment.model.Category;
import com.example.testassignment.model.Detail;
import com.example.testassignment.model.Movie;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Service
public class VotingServiceImpl implements VotingService {

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public Category getVotingData() {
        Movie movie = new Movie();
        Category category = new Category();
        String id = null;
        String desc = null;
        ArrayList<Detail> detailArrayList = new ArrayList<Detail>();
        ArrayList<Movie> movieArrayList = new ArrayList<Movie>();

        try {
            String content = IOUtils.toString(resourceLoader.getResource("classpath:data.json").getInputStream());
            Object obj = new JSONParser().parse(content);
            JSONObject jo = (JSONObject) obj;
            JSONArray movies = (JSONArray) jo.get("movies");
            Iterator movieIterator = movies.iterator();

            while (movieIterator.hasNext()) {
                Iterator iterator = ((JSONObject) movieIterator.next()).entrySet().iterator();
                Detail detail = new Detail();
                ArrayList<String> categ = new ArrayList<String>();

                while (iterator.hasNext()) {
                    Map.Entry pair = (Map.Entry) iterator.next();
                    if (pair.getKey().equals("id")) {
                        id = String.valueOf(pair.getValue());
                    }
                    if (pair.getKey().equals("description")) {
                        desc = String.valueOf(pair.getValue());
                    }
                    if (pair.getKey().equals("category")) {
                        categ.add(String.valueOf(pair.getValue()));
                    }
                    detail.setName(id);
                    detail.setDescription(desc);
                    detail.setCategory(categ);
                }
                detailArrayList.add(detail);
            }
            movie.setMovie(detailArrayList);
            movieArrayList.add(movie);
            category.setTypeofShow(movieArrayList);

        } catch (Exception fne) {
        }
        return category;
    }
}
