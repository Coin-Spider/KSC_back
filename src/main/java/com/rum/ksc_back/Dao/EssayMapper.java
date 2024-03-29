package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Rep.EssayRep;
import com.rum.ksc_back.domain.Ron.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayMapper {
    List<Essay> selectRedom();
}
