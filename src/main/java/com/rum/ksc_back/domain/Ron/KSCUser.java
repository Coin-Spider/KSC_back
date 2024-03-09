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

    public KSCUser(int userId, String nickName, String userName, String passWord, String email, int userState, int roleId, String salt, Timestamp onDate) {
        this.userId = userId;
        this.nickName = nickName;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.userState = userState;
        this.roleId = roleId;
        this.salt = salt;
        this.onDate = onDate;
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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KSCUser user = (KSCUser) o;
        return userId == user.userId && userState == user.userState && roleId == user.roleId && salt == user.salt && Objects.equals(nickName, user.nickName) && Objects.equals(userName, user.userName) && Objects.equals(passWord, user.passWord) && Objects.equals(email, user.email) && Objects.equals(onDate, user.onDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickName, userName, passWord, email, userState, roleId, salt, onDate);
    }
}
