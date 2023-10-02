package com.example.demo.controller;

import com.example.demo.model.Challenge;
import com.example.demo.service.ChallengeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @GetMapping
    public ResponseEntity<List<Challenge>> getAllChallengesList(
            @RequestParam(value = "statusId", defaultValue = "0") Integer statusId) throws Exception {
        return ResponseEntity.ok(this.challengeService.getChallengesList(statusId));
    }
}
