package com.rum.ksc_back.domain.Rep;

import com.rum.ksc_back.domain.Ron.Essay;
import com.rum.ksc_back.domain.Ron.KSCUser;
import com.rum.ksc_back.domain.Ron.Pic;
import com.rum.ksc_back.domain.Ron.Type;

import java.sql.Timestamp;

public class EssayRepHome {
    //Essay
    private final int essayId;

    private final String essayTittle;
    private final Timestamp onTime;
    //Type
    private final int typeId;
    private final String typeContent;
    //KSCUser
    private final int userId;
    private final String nickName;
    //else
    private final String userHead;
    private final String coverPath;


    public EssayRepHome(int essayId, String essayTittle, Timestamp onTime, int typeId, String typeContent, int userId, String nickName, String userHead, String coverPath) {
        this.essayId = essayId;
        this.essayTittle = essayTittle;
        this.onTime = onTime;
        this.typeId = typeId;
        this.typeContent = typeContent;
        this.userId = userId;
        this.nickName = nickName;
        this.userHead = userHead;
        this.coverPath = coverPath;
    }

    //构造方法
    public EssayRepHome(Essay essay, Type type, KSCUser kscUser, String coverPath, String userHead) {
        //Essay
        this.essayId = essay.getEssayId();
        this.coverPath = coverPath;
        this.essayTittle = essay.getEssayTittle();
        this.onTime = essay.getOnTime();
        //type
        this.typeId = type.getTypeId();
        this.typeContent = type.getTypeContent();
        //user
        this.userId = kscUser.getUserId();
        this.nickName = kscUser.getNickName();
        this.userHead = userHead;
    }

    public int getEssayId() {
        return essayId;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public String getEssayTittle() {
        return essayTittle;
    }

    public Timestamp getOnTime() {
        return onTime;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeContent() {
        return typeContent;
    }

    public int getUserId() {
        return userId;
    }

    public String getNickName() {
        return nickName;
    }

    public String getUserHead() {
        return userHead;
    }


}
