package com.rum.ksc_back.Dao;

import com.rum.ksc_back.domain.Ron.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ReviewMapper {
    //查询该文章所有评论
    List<Review> selectById(int essayId);
    //插入评论
    int insertReview(Review review);
    //通过id进行查询
    Review selectByReviewId(int reviewId);
}
