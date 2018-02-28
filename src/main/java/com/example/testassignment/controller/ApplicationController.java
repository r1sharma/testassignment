package com.example.testassignment.controller;

import com.example.testassignment.model.Detail;
import com.example.testassignment.service.VotingRepository;
import com.example.testassignment.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ApplicationController {

    private VotingService votingService;

    @Autowired
    VotingRepository votingRepository;



    @Autowired
    public void setVotingService(VotingService votingService) {
        this.votingService = votingService;
    }


    /*
    This method renders the index page to display list of movies with voting buttons
     */
    @RequestMapping(value ={"/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("category",votingService.getVotingData());
        return "index";
    }

    /*
    This method renders the result page on click of voting buttons
     */
    @RequestMapping(value = "/index/vote", method = RequestMethod.POST)
    public String vote(@RequestParam("id") String id, @RequestParam("desc") String desc, @RequestParam("category") String category, @RequestParam(value = "vote") String vote, Model model) {

        model.addAttribute("id", id);
        model.addAttribute("desc", desc);
        model.addAttribute("category", category);
        model.addAttribute("vote",vote);


        ArrayList<String> categoryList = new ArrayList<String>();
        categoryList.add(category);

        //save data to h2 db
        votingRepository.save(new Detail(id,desc,categoryList,vote));


        int voteCount = votingRepository.countVotes(vote,id);
        model.addAttribute("votecount",voteCount);


        return "result";
    }
}
