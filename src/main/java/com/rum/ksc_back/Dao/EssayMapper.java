package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Rep.EssayRep;
import com.rum.ksc_back.domain.Ron.Essay;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EssayMapper {
    List<Essay> selectRedom();
    Essay selectById(int essayId);
    Integer selectLike(int essayId);
    Integer isLiked(int essayId,int userId);
    Integer selectColltions(int essayId);
    Integer isCollectioned(int essayId,int userId);
    int findAuth(int essayId);
    void like(int userId,int essayId);
    void unLike(int userId,int essayId);
    void collection(int userId,int essayId);
    void unCollection(int userId,int essayId);
}
