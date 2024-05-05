package com.rum.ksc_back.domain.Rep;

import java.sql.Timestamp;
import java.util.ArrayList;

public class EssayRepPage {
    //user
    private String essayText;
    private Integer like;
    private Integer colltions;
    private Timestamp onTime;
    private String headPath;
    private String nickName;
    private int userId;
    private Integer Followers;
    private ArrayList<ReviewRep> reviewList;
    private int isLiked;
    private int isCollected;

    public int getIsFollowed() {
        return isFollowed;
    }

    public void setIsFollowed(int isFollowed) {
        this.isFollowed = isFollowed;
    }

    private int isFollowed;

    public EssayRepPage() {
    }

    public EssayRepPage(String essayText, Integer like, Integer colltions, Timestamp onTime, String headPath, String nickName, int userId, Integer followers, ArrayList<ReviewRep> reviewList, int isLiked, int isCollected, int isFollowed) {
        this.essayText = essayText;
        this.like = like;
        this.colltions = colltions;
        this.onTime = onTime;
        this.headPath = headPath;
        this.nickName = nickName;
        this.userId = userId;
        Followers = followers;
        this.reviewList = reviewList;
        this.isLiked = isLiked;
        this.isCollected = isCollected;
        this.isFollowed=isFollowed;
    }

    public String getEssayText() {
        return essayText;
    }

    public void setEssayText(String essayText) {
        this.essayText = essayText;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getColltions() {
        return colltions;
    }

    public void setColltions(Integer colltions) {
        this.colltions = colltions;
    }

    public Timestamp getOnTime() {
        return onTime;
    }

    public void setOnTime(Timestamp onTime) {
        this.onTime = onTime;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getFollowers() {
        return Followers;
    }

    public void setFollowers(Integer followers) {
        Followers = followers;
    }

    public ArrayList<ReviewRep> getReviewList() {
        return reviewList;
    }

    public void setReviewList(ArrayList<ReviewRep> reviewList) {
        this.reviewList = reviewList;
    }

    public int getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(int isLiked) {
        this.isLiked = isLiked;
    }

    public int getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(int isCollected) {
        this.isCollected = isCollected;
    }
}
