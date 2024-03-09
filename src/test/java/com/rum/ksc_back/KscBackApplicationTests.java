package com.rum.ksc_back;

import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.Utils.JwtUtil;
import com.rum.ksc_back.Utils.SecretUtil;
import com.rum.ksc_back.domain.Ron.KSCUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

@SpringBootTest
class KscBackApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String[] args) {
//        ZonedDateTime now = ZonedDateTime.now();
//        System.out.println(now);
//        KSCUser user=new KSCUser(0,"1","wwww",null,null,1,1,"sada", Timestamp.valueOf(ZonedDateTime.now().toLocalDateTime()));
//        System.out.println(JwtUtil.chTimeEx(JwtUtil.getJwt(user)));
    }

}
