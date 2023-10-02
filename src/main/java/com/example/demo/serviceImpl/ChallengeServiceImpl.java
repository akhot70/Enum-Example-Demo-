package com.example.demo.serviceImpl;

import com.example.demo.model.Challenge;
import com.example.demo.model.ChallengeStatus;
import com.example.demo.repository.ChallengeRepository;
import com.example.demo.service.ChallengeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ChallengeServiceImpl implements ChallengeService {


    private final ChallengeRepository challengeRepository;

    public ChallengeServiceImpl(ChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public List<Challenge> getChallengesList(Integer challengeStatus) throws Exception {
        List<Challenge> list = new ArrayList<>();
        if (challengeStatus == 0) {
            list = this.challengeRepository.findAll();
            if (!Objects.nonNull(list)) {
                throw new Exception("Challenge not found");
            }
        } else if (isValidStatusId(challengeStatus)) {
            list = this.challengeRepository.allChallenges(getChallengeStatus(challengeStatus));
            if (list.isEmpty()) {
                throw new Exception("Challenge not found");
            }
        }
        return list;
    }

    private ChallengeStatus getChallengeStatus(Integer challengeStatus) throws Exception {
        ChallengeStatus challengeStatus1;

        switch (challengeStatus) {
            case 1 -> challengeStatus1 = ChallengeStatus.DRAFT;
            case 2 -> challengeStatus1 = ChallengeStatus.READY;
            case 3 -> challengeStatus1 = ChallengeStatus.ACTIVE;
            case 4 -> challengeStatus1 = ChallengeStatus.CLOSED;
            case 5 -> challengeStatus1 = ChallengeStatus.CANCELLED;
            case 6 -> challengeStatus1 = ChallengeStatus.MISSED;
            default -> throw new Exception("Invalid statusId");
        }
        return challengeStatus1;
    }

    private static boolean isValidStatusId(Integer challengeStatus) throws Exception {
        if (challengeStatus >= ChallengeStatus.DRAFT.value() && challengeStatus <= ChallengeStatus.MISSED.value()) {
            return true;
        } else {
            throw new Exception("Invalid statusId");
        }
    }
}
