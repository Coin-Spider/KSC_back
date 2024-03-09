package com.rum.ksc_back.Services.User.Impl;

import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.KSCException.ApiError;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Security.SecurityUser;
import com.rum.ksc_back.Services.User.UserServices;
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
        String token = JwtUtil.getJwt(user2);
        System.out.println(token);
        return new KSCUserRep(user2,token);
    }

    @Override
    public KSCUserRep Register(KSCUser kscUser) {
        //生成盐码
        kscUser.setSalt(SecretUtil.getSalt());
        //替换更改后密码
        kscUser.setPassWord(SecretUtil.EnSecret(kscUser.getSalt(),kscUser.getPassWord()));
        //先保存
        userMapper.InsertUser(kscUser);
        //返回登录对象
        return Login(userMapper.getByUserName(kscUser.getUserName()));
    }
}
