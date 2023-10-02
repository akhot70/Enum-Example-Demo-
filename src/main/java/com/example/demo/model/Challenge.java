package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="challenge_id")
    private int challengeId;

    @Column(name = "challenge_Type")
    private int challengeType;

    @Column(name = "challenge_Name")
    private String challengeName;

    @Column(name = "summary")
    private String summary;

    @Column(name = "comments")
    private String comments;

    @Column(name = "participant_Count")
    private int participantCount;

    @Column(name = "question_Id")
    private int questionId;

    @Column(name = "challenge_Status")
    @Enumerated(EnumType.STRING)
    private ChallengeStatus challengeStatus;
}
