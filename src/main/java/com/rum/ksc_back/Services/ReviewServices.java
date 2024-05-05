package com.rum.ksc_back.Services;

import com.rum.ksc_back.domain.Rep.ReviewRep;
import org.springframework.stereotype.Service;

@Service
public interface ReviewServices {
    ReviewRep ReplyEssay(int essayId,int reviewUser,String reviewContent);
}
