package com.example.demo.repository;

import com.example.demo.model.Challenge;
import com.example.demo.model.ChallengeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

    @Query("FROM Challenge WHERE challengeStatus=?1")
    List<Challenge> allChallenges(ChallengeStatus statusId);
}
