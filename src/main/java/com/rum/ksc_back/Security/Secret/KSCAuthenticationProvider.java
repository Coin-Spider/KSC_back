package com.rum.ksc_back.Security.Secret;

import com.rum.ksc_back.Dao.RoleMapper;
import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.KSCException.ApiError;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Security.SecurityUser;
import com.rum.ksc_back.Utils.SecretUtil;
import com.rum.ksc_back.domain.Ron.KSCUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class KSCAuthenticationProvider implements AuthenticationProvider, UserDetailsService {
    @Autowired private UserMapper userMapper;
    @Autowired private RoleMapper roleMapper;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SecurityUser s= (SecurityUser) loadUserByUsername(authentication.getName());
        String passWord = s.getUser().getPassWord();
        if (!SecretUtil.ChSecret((String) authentication.getCredentials(),passWord)){
            throw  new ApiException(ApiError.PasswordNotCreat);
        }

        return new UsernamePasswordAuthenticationToken(s,authentication.getCredentials(),s.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //字段处理
        username=username.replace("\"","");
        KSCUser user = userMapper.getByUserName(username);
        if (Objects.isNull(user)){
            throw new ApiException(ApiError.UserNotFound);
        }
        if (user.getUserState()==0){
            throw new ApiException(ApiError.UserNotAllowed);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //添加 Authorities
        authorities.add(new SimpleGrantedAuthority(roleMapper.SelectById(user.getRoleId()).getRoleName()));
        return new SecurityUser(user, authorities);
    }
}
