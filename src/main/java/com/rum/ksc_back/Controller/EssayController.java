package com.rum.ksc_back.Controller;

import com.rum.ksc_back.Config.Request;
import com.rum.ksc_back.Services.EssayServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Essay")
public class EssayController {
    @Autowired private EssayServices essayServices;
    @GetMapping("/Homing")
    public Request Essayhome(){
        return new Request("1",essayServices.homing());
    }
    @GetMapping("/EssayPage/{essayId}")
    public Request EssayPage(@PathVariable int essayId,int userId){

        return new Request("1",essayServices.essayPage(essayId,userId));
    }
    //点赞
    @GetMapping("/like")
    public Request like(int userId,int essayId){
        if (essayServices.like(userId,essayId)){
            return new Request("1","操作成功");
        }
        return new Request("500","未知错误");
    }
    //取消点赞
    @GetMapping("/unLike")
    public Request unLike(int userId,int essayId){
        if (essayServices.unLike(userId,essayId)){
            return new Request("1","操作成功");
        }
        return new Request("500","未知错误");
    }
    //收藏
    @GetMapping("/collection")
    public Request collection(int userId,int essayId){
        if (essayServices.collection(userId,essayId)){
            return new Request("1","操作成功");
        }
        return new Request("500","未知错误");
    }
    //取消收藏
    @GetMapping("/unCollection")
    public Request unCollection(int userId,int essayId){
        if (essayServices.unCollection(userId,essayId)){
            return new Request("1","操作成功");
        }
        return new Request("500","未知错误");
    }
}
