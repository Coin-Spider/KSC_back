package com.rum.ksc_back.Services.Impl;

import com.rum.ksc_back.Dao.*;
import com.rum.ksc_back.KSCException.ApiError;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Services.EssayServices;
import com.rum.ksc_back.domain.Rep.EssayRepHome;
import com.rum.ksc_back.domain.Rep.EssayRepPage;
import com.rum.ksc_back.domain.Rep.ReviewRep;
import com.rum.ksc_back.domain.Ron.Essay;
import com.rum.ksc_back.domain.Ron.KSCUser;
import com.rum.ksc_back.domain.Ron.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EssayServicesImpl implements EssayServices {
    @Autowired private EssayMapper essayMapper;
    @Autowired private TypeMapper typeMapper;
    @Autowired private UserMapper userMapper;
    @Autowired private PicMapper picMapper;
    @Autowired private ReviewMapper reviewMapper;
    @Override
    public List<EssayRepHome> homing() {
        List<EssayRepHome> res=new ArrayList<>();
        List<Essay> essays = essayMapper.selectRedom();
        for (Essay essay : essays) {
            KSCUser user = userMapper.getByUserId(essay.getUserId());
            EssayRepHome essayRepHome = new EssayRepHome(essay, typeMapper.getById(essay.getType()), user, picMapper.getPicUrl(essay.getCover()), picMapper.getPicUrl(user.getPicId()));
            res.add(essayRepHome);
        }
        Collections.shuffle(res);
        return res;
    }

    @Override
    public EssayRepPage essayPage(int essayId, int userId) {
        String picIp="http://1.14.204.162/img";
        Essay essay = essayMapper.selectById(essayId);
        if (essay.getEssayState()!=1){
            throw new ApiException(ApiError.ResourcesNotAllowed);
        }
        KSCUser user = userMapper.getByUserId(essay.getUserId());
        if (user.getUserState()!=1){
            throw new ApiException(ApiError.ResourcesNotAllowed);
        }
        List<Review> reviews = reviewMapper.selectById(essayId);
        ArrayList<ReviewRep> reviewList=new ArrayList<>();
        ReviewRep review_F;
        KSCUser reviewUser_F;
        KSCUser reviewUser_C;
        for (int i = 0; i < reviews.size(); i++) {
            if (reviews.get(i).getReviewFatherId()!=0){
                continue;
            }
            reviewUser_F = userMapper.getByUserId(reviews.get(i).getReviewUser());
            review_F=new ReviewRep(reviews.get(i), picIp+picMapper.getPicUrl(reviewUser_F.getPicId()),reviewUser_F.getNickName(), userMapper.getNickNameById(reviews.get(i).getReviewTo()));
            review_F.setReviewChi(new ArrayList<>());
            for (int i1 = 0; i1 < reviews.size(); i1++) {
                if (i1==i){
                    continue;
                }
                if (reviews.get(i1).getReviewFatherId()==reviews.get(i).getReviewId()){
                    reviewUser_C = userMapper.getByUserId(reviews.get(i1).getReviewUser());
                    review_F.getReviewChi().add(new ReviewRep(reviews.get(i1), picIp+picMapper.getPicUrl(reviewUser_C.getPicId()), reviewUser_C.getNickName(),userMapper.getNickNameById(reviews.get(i1).getReviewTo())));
                }
            }
            reviewList.add(review_F);
        }
        return new EssayRepPage(essay.getEssayText(),essayMapper.selectLike(essayId),essayMapper.selectColltions(essayId),
                essay.getOnTime(),picIp+picMapper.getPicUrl(user.getPicId()),user.getNickName(),user.getUserId(),
                userMapper.getFollowers(user.getUserId()),reviewList,essayMapper.isLiked(essayId,userId),
                essayMapper.isCollectioned(essayId,userId),userMapper.isFollowered(user.getUserId(),userId));
    }

    @Override
    public boolean like(int userId, int essayId) {
        //拿到essay的所有者,比对是否为自己的文章,如果为自己的文章,不能点赞,如果不是自己的文章,可以点赞
        if (userId==essayMapper.findAuth(essayId)){
            return false;
        }
        //不是自己的文章,开始点赞
        essayMapper.like(userId,essayId);
        //插入完成,开始检查是否点赞成功
        return essayMapper.isLiked(essayId, userId) > 0;
    }

    @Override
    public boolean unLike(int userId, int essayId) {
        //拿到essay的所有者,比对是否为自己的文章,如果为自己的文章,不能点赞,如果不是自己的文章,可以点赞
        if (userId==essayMapper.findAuth(essayId)){
            return false;
        }
        //不是自己的文章,开始取消点赞
        essayMapper.unLike(userId,essayId);
        //插入完成,开始检查是否取消点赞成功
        return essayMapper.isLiked(essayId, userId) == 0;
    }

    @Override
    public boolean collection(int userId, int essayId) {
        if (userId==essayMapper.findAuth(essayId)){
            return false;
        }
        essayMapper.collection(userId,essayId);
        return essayMapper.isCollectioned(essayId,userId)>0;
    }

    @Override
    public boolean unCollection(int userId, int essayId) {
        if (userId==essayMapper.findAuth(essayId)){
            return false;
        }
        essayMapper.unCollection(userId,essayId);
        return essayMapper.isCollectioned(essayId,userId)==0;
    }

}
