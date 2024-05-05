package com.rum.ksc_back;

import cn.hutool.core.collection.ListUtil;
import com.auth0.jwt.JWT;
import com.jayway.jsonpath.internal.function.numeric.Sum;
import com.rum.ksc_back.Controller.ReviewController;
import com.rum.ksc_back.Dao.ReviewMapper;
import com.rum.ksc_back.Utils.JwtUtil;
import com.rum.ksc_back.domain.Ron.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

import static java.time.temporal.ChronoField.OFFSET_SECONDS;

@SpringBootTest
class KscBackApplicationTests {
    @Autowired
    private ReviewMapper reviewMapper;
    @Autowired
    private ReviewController reviewController;

    @Test
    void contextLoads() {
        Review review = new Review(0, 0, "测试", 15, 6, null, 0);
        System.out.println(reviewController.ReplyEssay("测试", 6, 15).getBody());
    }

    public static void main(String[] args) {
//        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println(now);
//        KSCUser user=new KSCUser(0,"1","wwww",null,null,1,1,"sada", Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime()));
//        System.out.println(JwtUtil.chTimeEx(JwtUtil.getJwt(user)));
//        System.out.println(JwtUtil.getNow().getLong(OFFSET_SECONDS));
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        System.out.println(timestamp.getTime() % 26300000);
    }


}

