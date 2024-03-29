package com.rum.ksc_back.Dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PicMapper {
    String getPicUrl(int picId);
}
