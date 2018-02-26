package com.example.testassignment.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "VOTING")
public class Detail {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="CATEGORY")
    private ArrayList<String> category;

    @Column(name="VOTE")
    private String vote;

    public Detail(){}

    public Detail(String name, String description, ArrayList<String> category, String vote) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.vote = vote;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }
}
