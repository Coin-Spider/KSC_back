package com.rum.ksc_back.domain.Rep;

import java.sql.Timestamp;

public class EssayRep {
    private int essayId;
    private String coverUrl;
    private String essayTittle;
    private int userId;
    private String NickName;
    private Timestamp onTime;
    private int type;
    private String typeContent;
    private String essayText;

    public int getEssayId() {
        return essayId;
    }

    public void setEssayId(int essayId) {
        this.essayId = essayId;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
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

    public String getTypeContent() {
        return typeContent;
    }

    public void setTypeContent(String typeContent) {
        this.typeContent = typeContent;
    }

    public String getEssayText() {
        return essayText;
    }

    public void setEssayText(String essayText) {
        this.essayText = essayText;
    }

    public EssayRep(int essayId, String coverUrl, String essayTittle, int userId, String nickName, Timestamp onTime, int type, String typeContent, String essayText) {
        this.essayId = essayId;
        this.coverUrl = coverUrl;
        this.essayTittle = essayTittle;
        this.userId = userId;
        NickName = nickName;
        this.onTime = onTime;
        this.type = type;
        this.typeContent = typeContent;
        this.essayText = essayText;
    }
}
