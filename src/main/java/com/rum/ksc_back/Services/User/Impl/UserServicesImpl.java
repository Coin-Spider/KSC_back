package com.rum.ksc_back.Services.User.Impl;

import cn.hutool.crypto.BCUtil;
import com.rum.ksc_back.Dao.PicMapper;
import com.rum.ksc_back.Dao.RoleMapper;
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
import org.springframework.security.crypto.bcrypt.BCrypt;
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
        String token = JwtUtil.getJwt(user2);
        if (user2.getUserState()==0){
            throw new ApiException(ApiError.UserNotAllowed);
        }
        return new KSCUserRep(user2,token,roleMapper.SelectById(user2.getRoleId()), picMapper.getPicUrl(user2.getPicId()));
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

    @Override
    public KSCUserRep cheTokenTime(int user_Id) {
        KSCUser byUserId = userMapper.getByUserId(user_Id);
        return Login(byUserId);
    }
}
