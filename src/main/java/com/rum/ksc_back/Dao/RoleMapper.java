package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Ron.Role;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleMapper {
    //通过RoleId查询身份
    Role SelectById(int roleId);
}
