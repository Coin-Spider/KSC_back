package com.rum.ksc_back.domain.Rep;

import com.rum.ksc_back.domain.Ron.KSCUser;

import java.sql.Timestamp;
import java.util.Objects;

public class KSCUserRep {
    private int userId;
    private String nickName;
    private String userName;
    private String email;
    private int roleId;
    private String token;
    private Timestamp onDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KSCUserRep that = (KSCUserRep) o;
        return userId == that.userId && roleId == that.roleId && Objects.equals(nickName, that.nickName) && Objects.equals(userName, that.userName) && Objects.equals(email, that.email) && Objects.equals(token, that.token) && Objects.equals(onDate, that.onDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, nickName, userName, email, roleId, token, onDate);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getOnDate() {
        return onDate;
    }

    public void setOnDate(Timestamp onDate) {
        this.onDate = onDate;
    }

    public KSCUserRep(KSCUser kscUser, String token) {
        this.userId = kscUser.getUserId();
        this.nickName = kscUser.getNickName();
        this.userName = kscUser.getUserName();
        this.email = kscUser.getEmail();
        this.roleId = kscUser.getRoleId();
        this.token = token;
        this.onDate = kscUser.getOnDate();
    }
}
