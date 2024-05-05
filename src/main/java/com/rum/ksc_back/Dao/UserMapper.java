package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Ron.KSCUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    KSCUser getByUserName(String userName);
    void InsertUser(KSCUser kscUser);
    KSCUser getByUserId(int userId);
    Integer getFollowers(int userId);
    int isFollowered(int beFollowed,int userId);
    String getNickNameById(int userId);
    void follow(int userId, int beFollowedId);
    void delFollow(int userId, int beFollowedId);
}
