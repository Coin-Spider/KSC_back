package com.rum.ksc_back.Services.Impl;

import com.auth0.jwt.JWT;
import com.rum.ksc_back.Dao.PicMapper;
import com.rum.ksc_back.Dao.RoleMapper;
import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.KSCException.ApiError;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Security.SecurityUser;
import com.rum.ksc_back.Services.UserServices;
import com.rum.ksc_back.Utils.JwtUtil;
import com.rum.ksc_back.Utils.SecretUtil;
import com.rum.ksc_back.domain.Ron.KSCUser;
import com.rum.ksc_back.domain.Rep.KSCUserRep;
import jakarta.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired private UserMapper userMapper;
    @Autowired private RoleMapper roleMapper;
    @Autowired private PicMapper picMapper;
    @Resource private AuthenticationManager authenticationManager;
    @Override
    public KSCUser getUserByUserName(String userName) {
        return userMapper.getByUserName(userName);
    }

    @Override
    public KSCUserRep Login(KSCUser kscUser) {
        KSCUser user2;

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(kscUser.getUserName(),kscUser.getPassWord());
        Authentication authentication= authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(Objects.isNull(authentication)){
            throw new ApiException(ApiError.PasswordNotCreat);
        }

        SecurityUser securityUser= (SecurityUser) authentication.getPrincipal();
        user2=securityUser.getUser();
        if (user2.getUserState()==0){
            throw new ApiException(ApiError.UserNotAllowed);
        }
        String token = JwtUtil.getJwt(user2);
        System.out.println("New Token Has Been Create Will Been Expires At : "+ JWT.decode(token).getExpiresAt());
        return new KSCUserRep(user2,token,roleMapper.SelectById(user2.getRoleId()), picMapper.getPicUrl(user2.getPicId()));
    }

    @Override
    public KSCUserRep Register(KSCUser kscUser) {
        if (userMapper.getByUserName(kscUser.getUserName())!=null){
            throw new ApiException(ApiError.UserAreadyFind);
        }
        //生成盐码
        kscUser.setSalt(SecretUtil.getSalt());
        //替换更改后密码
        kscUser.setPassWord(SecretUtil.EnSecret(kscUser.getSalt(),kscUser.getPassWord()));
        //先保存
        userMapper.InsertUser(kscUser);
        //返回登录对象
        return Login(userMapper.getByUserName(kscUser.getUserName()));
    }

    @Override
    public KSCUserRep cheTokenTime(int user_Id) {
        KSCUser byUserId = userMapper.getByUserId(user_Id);
        if (Objects.isNull(byUserId)){
            throw new ApiException(ApiError.UserNotFound);
        }
        return Login(byUserId);
    }

    @Override
    public boolean follow(int userId, int beFollowedId) {
        //过滤器过关,开始关注
        //检查受否已经关注(即使前端已经进行了鉴定)
        if (userMapper.isFollowered(beFollowedId,userId)>0){
            //已经关注了,爆异常
            return false;
        }
        //没关注,进行数据库插入
        userMapper.follow(userId,beFollowedId);
        //检查是否关注成功
        if (userMapper.isFollowered(beFollowedId,userId)<=0){
            return false;
            //关注失败,爆!
        }
        //没问题,返回true
        return true;
    }

    @Override
    public boolean delFollow(int userId, int beFollowedId) {
        //过滤器过关,开始关注
        //检查受否已经关注(即使前端已经进行了鉴定)
        if (userMapper.isFollowered(beFollowedId,userId)<=0){
            //没关注,爆异常
            return false;
        }
        //关注了,进行数据库删除
        userMapper.delFollow(userId,beFollowedId);
        //检查是否关注成功
        if (userMapper.isFollowered(beFollowedId,userId)>0){
            //取消关注失败,爆!
            return false;
        }
        //没问题,返回true
        return true;
    }
}
