package com.rum.ksc_back.domain.Ron;

import java.sql.Timestamp;

public class Essay {
    private int essayId;
    private int cover;
    private String essayTittle;
    private int userId;
    private Timestamp onTime;
    private int type;
    private int essayState;
    private String essayText;

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public String getEssayTittle() {
        return essayTittle;
    }

    public void setEssayTittle(String essayTittle) {
        this.essayTittle = essayTittle;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getOnTime() {
        return onTime;
    }

    public void setOnTime(Timestamp onTime) {
        this.onTime = onTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getEssayState() {
        return essayState;
    }

    public void setEssayState(int essayState) {
        this.essayState = essayState;
    }

    public String getEssayText() {
        return essayText;
    }

    public void setEssayText(String essayText) {
        this.essayText = essayText;
    }

    public Essay(int essayId, int cover, String essayTittle, int userId, Timestamp onTime, int type, int essayState, String essayText) {
        this.essayId = essayId;
        this.cover = cover;
        this.essayTittle = essayTittle;
        this.userId = userId;
        this.onTime = onTime;
        this.type = type;
        this.essayState = essayState;
        this.essayText = essayText;
    }
}
