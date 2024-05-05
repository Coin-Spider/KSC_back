package com.rum.ksc_back.domain.Rep;

import com.rum.ksc_back.domain.Ron.KSCUser;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.Objects;

public class KSCUserRep {
    private int userId;
    private String nickName;
    private String email;
    private String role;
    private String token;
    private String picUrl;
    private Timestamp onDate;

    public KSCUserRep(KSCUser kscUser, String token, String role, String picUrl) {
        this.userId = kscUser.getUserId();
        this.nickName = kscUser.getNickName();
        this.email = kscUser.getEmail();
        this.role = role;
        this.token = token;
        this.picUrl = picUrl;
        this.onDate = kscUser.getOnDate();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Timestamp getOnDate() {
        return onDate;
    }

    public void setOnDate(Timestamp onDate) {
        this.onDate = onDate;
    }

    public KSCUserRep(int userId, String nickName, String email, String role, String token, String picUrl, Timestamp onDate) {
        this.userId = userId;
        this.nickName = nickName;
        this.email = email;
        this.role = role;
        this.token = token;
        this.picUrl = picUrl;
        this.onDate = onDate;
    }
}
