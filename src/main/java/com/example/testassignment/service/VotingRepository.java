package com.example.testassignment.service;

import com.example.testassignment.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VotingRepository extends JpaRepository<Detail, Long> {

    // Shows vote count for upvote or downvote
    @Query("select count(*) from Detail v  where v.vote <> 'null' and v.vote =?1 and v.name=?2")
    int countVotes(String vote, String name);
}
