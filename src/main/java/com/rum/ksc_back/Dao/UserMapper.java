package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Ron.KSCUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    KSCUser getByUserName(String userName);

    void InsertUser(KSCUser kscUser);
}
