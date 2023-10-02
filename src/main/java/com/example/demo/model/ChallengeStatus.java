package com.example.demo.model;

public enum ChallengeStatus {

    DRAFT(1), READY(2), ACTIVE(3), CLOSED(4), CANCELLED(5), MISSED(6);

    private int index;

    ChallengeStatus(int index) {
        this.index = index;
    }

    public int value() {
        return this.index;
    }
}
