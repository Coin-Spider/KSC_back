package com.rum.ksc_back.Security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import java.util.Arrays;
import java.util.Objects;

public class KSCPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        // 进行一个md5加密
        System.out.println("encode");
        return (String) rawPassword;
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        // 通过md5校验
        System.out.println("matches");
        return rawPassword.equals(encodedPassword)|| Objects.equals(rawPassword,encodedPassword);
    }
}
