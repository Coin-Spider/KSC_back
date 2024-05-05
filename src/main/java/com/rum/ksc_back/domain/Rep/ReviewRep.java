package com.rum.ksc_back.domain.Rep;

import com.rum.ksc_back.domain.Ron.Review;

import java.sql.Timestamp;
import java.util.ArrayList;

public class ReviewRep {
    private int reviewId;
    private ArrayList<ReviewRep> reviewChi;
    private String reviewContent;
    private int reviewUser;
    private String userHead;
    private String userNickName;
    private int essayId;
    private Timestamp onTime;
    private int reviewToId;
    private String reviewToNickName;

    public int getReviewToId() {
        return reviewToId;
    }

    public void setReviewToId(int reviewToId) {
        this.reviewToId = reviewToId;
    }

    public String getReviewToNickName() {
        return reviewToNickName;
    }

    public void setReviewToNickName(String reviewToNickName) {
        this.reviewToNickName = reviewToNickName;
    }

    public ReviewRep() {
    }

    public String getUserHead() {
        return userHead;
    }

    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public ReviewRep(Review review, String userHead, String userNickName,String reviewToNickName) {
        this.reviewId = review.getReviewId();
        this.reviewContent = review.getReviewContent();
        this.reviewUser = review.getReviewUser();
        this.essayId = review.getEssayId();
        this.onTime = review.getOnTime();
        this.userHead=userHead;
        this.userNickName=userNickName;
        this.reviewToId=review.getReviewTo();
        this.reviewToNickName=reviewToNickName;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public ArrayList<ReviewRep> getReviewChi() {
        return reviewChi;
    }

    public void setReviewChi(ArrayList<ReviewRep> reviewChi) {
        this.reviewChi = reviewChi;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public int getReviewUser() {
        return reviewUser;
    }

    public void setReviewUser(int reviewUser) {
        this.reviewUser = reviewUser;
    }

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public Timestamp getOnTime() {
        return onTime;
    }

    public void setOnTime(Timestamp onTime) {
        this.onTime = onTime;
    }




}
