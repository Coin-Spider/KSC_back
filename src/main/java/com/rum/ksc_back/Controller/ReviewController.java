package com.rum.ksc_back.Controller;

import com.rum.ksc_back.Config.Request;
import com.rum.ksc_back.Services.ReviewServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    @Autowired private ReviewServices reviewServices;
    //回复评论
    @PostMapping("/ReplyReview")
    public Request ReplyReview(int reviewId,int userId,int reviewTo){

        return new Request("1",null);
    }
    //评论
    @PostMapping("/ReplyEssay")
    public Request ReplyEssay(String reviewContent,int essayId,int reviewUser){
        return new Request("1",reviewServices.ReplyEssay(essayId,reviewUser,reviewContent));
    }
}
