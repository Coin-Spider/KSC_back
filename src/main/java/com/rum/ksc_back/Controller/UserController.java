package com.rum.ksc_back.Controller;

import com.rum.ksc_back.Config.Request;
import com.rum.ksc_back.KSCException.ApiError;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Services.User.UserServices;
import com.rum.ksc_back.domain.Ron.KSCUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired private UserServices userServices;
    @RequestMapping("/test")
    public Request test(){
        return new Request("1","成功");
    }
    @PostMapping("/Login")
    public Request UserLogin(@RequestBody KSCUser kscUser){
        if ( Objects.isNull(kscUser.getUserName()) ||kscUser.getUserName().isBlank()){
            throw new ApiException(ApiError.LoginFailed);
        }
        if (Objects.isNull(kscUser.getPassWord())||kscUser.getPassWord().isBlank()){
            throw new ApiException(ApiError.LoginFailed);
        }
        return new Request("1",userServices.Login(kscUser));
    }
    //注册
    @PostMapping("/Register")
    public Request register(@RequestBody KSCUser kscUser){
        //检验信息是否齐全
        if (Objects.isNull(kscUser.getNickName())||kscUser.getNickName().isBlank()){
            throw new ApiException(ApiError.NeedMoreInfo);
        }
        if (Objects.isNull(kscUser.getEmail())||kscUser.getEmail().isBlank()){
            throw new ApiException(ApiError.NeedMoreInfo);
        }
        if (Objects.isNull(kscUser.getUserName())||kscUser.getUserName().isBlank()){
            throw new ApiException(ApiError.NeedMoreInfo);
        }
        if (Objects.isNull(kscUser.getPassWord())||kscUser.getPassWord().isBlank()){
            throw new ApiException(ApiError.NeedMoreInfo);
        }
        return new Request("1",userServices.Register(kscUser));
    }

    @GetMapping("/chToken")
    public Request chTokenTime(int userId){
        if (Objects.isNull(userId)){
            throw new ApiException(ApiError.Fail);
        }
        return new Request("1",userServices.cheTokenTime(userId));
    }

}
