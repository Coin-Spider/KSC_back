package com.rum.ksc_back.domain.Ron;

import java.sql.Timestamp;

public class Review {
    private int reviewId;
    private int reviewFatherId;
    private String reviewContent;
    private int reviewUser;
    private int essayId;
    private Timestamp onTime;
    private int reviewTo;

    public Review() {
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setReviewFatherId(int reviewFatherId) {
        this.reviewFatherId = reviewFatherId;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public void setReviewUser(int reviewUser) {
        this.reviewUser = reviewUser;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public void setOnTime(Timestamp onTime) {
        this.onTime = onTime;
    }

    public void setReviewTo(int reviewTo) {
        this.reviewTo = reviewTo;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getReviewFatherId() {
        return reviewFatherId;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public int getReviewUser() {
        return reviewUser;
    }

    public int getEssayId() {
        return essayId;
    }

    public Timestamp getOnTime() {
        return onTime;
    }

    public int getReviewTo() {
        return reviewTo;
    }

    public Review(int reviewId, int reviewFatherId, String reviewContent, int reviewUser, int essayId, Timestamp onTime, int reviewTo) {
        this.reviewId = reviewId;
        this.reviewFatherId = reviewFatherId;
        this.reviewContent = reviewContent;
        this.reviewUser = reviewUser;
        this.essayId = essayId;
        this.onTime = onTime;
        this.reviewTo = reviewTo;
    }
}
