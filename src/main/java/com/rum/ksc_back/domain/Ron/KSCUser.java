package com.rum.ksc_back.domain.Ron;

import java.sql.Timestamp;
import java.util.Objects;

public class KSCUser {
    private int userId;
    private String nickName;
    private String userName;
    private String passWord;
    private String email;
    private int userState;
    private int roleId;
    private String salt;
    private Timestamp onDate;
    private int picId;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Timestamp getOnDate() {
        return onDate;
    }

    public void setOnDate(Timestamp onDate) {
        this.onDate = onDate;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public KSCUser(int userId, String nickName, String userName, String passWord, String email, int userState, int roleId, String salt, Timestamp onDate, int picId) {
        this.userId = userId;
        this.nickName = nickName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.userState = userState;
        this.roleId = roleId;
        this.salt = salt;
        this.onDate = onDate;
        this.picId = picId;
    }
}
