package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Ron.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper {
    Type getById(int typeId);
}
