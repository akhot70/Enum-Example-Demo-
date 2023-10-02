package com.example.demo.service;

import com.example.demo.model.Challenge;

import java.util.List;

public interface ChallengeService {

    List<Challenge> getChallengesList(Integer challengeStatus) throws Exception;
}
