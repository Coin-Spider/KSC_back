package com.rum.ksc_back.Security;

import com.rum.ksc_back.domain.Ron.KSCUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class SecurityUser extends User {
    private KSCUser user;
    public SecurityUser(KSCUser user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserName(), user.getPassWord(), authorities);
        this.user=user;
    }

    public KSCUser getUser(){
        return this.user;
    }

    public void setUser(KSCUser user){
        this.user=user;
    }
}
