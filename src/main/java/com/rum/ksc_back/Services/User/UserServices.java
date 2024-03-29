package com.rum.ksc_back.Services.User;

import com.rum.ksc_back.domain.Ron.KSCUser;
import com.rum.ksc_back.domain.Rep.KSCUserRep;
import org.springframework.stereotype.Service;

@Service
public interface UserServices {
    KSCUser getUserByUserName(String userName);
    KSCUserRep Login(KSCUser kscUser);
    KSCUserRep Register(KSCUser kscUser);
    KSCUserRep cheTokenTime(int user_Id);
}
