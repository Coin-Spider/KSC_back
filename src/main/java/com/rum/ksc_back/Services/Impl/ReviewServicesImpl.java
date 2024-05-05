package com.rum.ksc_back.Services.Impl;

import com.rum.ksc_back.Dao.PicMapper;
import com.rum.ksc_back.Dao.ReviewMapper;
import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Services.ReviewServices;
import com.rum.ksc_back.domain.Rep.ReviewRep;
import com.rum.ksc_back.domain.Ron.KSCUser;
import com.rum.ksc_back.domain.Ron.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ReviewServicesImpl implements ReviewServices {
    @Autowired private ReviewMapper reviewMapper;
    @Autowired private PicMapper picMapper;
    @Autowired private UserMapper userMapper;
    private final String[] notAllowed={"傻逼","操你妈","草你妈"};
    @Override
    public ReviewRep ReplyEssay(int essayId,int reviewUser,String reviewContent) {
        //检查是否有该用户
        KSCUser user = userMapper.getByUserId(reviewUser);
        if (Objects.isNull(user)){
            throw new ApiException("500","错误");
        }
        for (String s : notAllowed) {
            if (reviewContent.contains(s)){
                throw new ApiException("500","错误");
            }
        }
        Review review=new Review(0,0,reviewContent,reviewUser,essayId,null,0);
        //违禁检查通过,开始进行数据库处理
        reviewMapper.insertReview(review);
        review=reviewMapper.selectByReviewId(review.getReviewId());
        return new ReviewRep(review,picMapper.getPicUrl(user.getPicId()),user.getNickName(),null);
    }
}
