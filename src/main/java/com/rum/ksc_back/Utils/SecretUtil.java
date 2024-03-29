package com.rum.ksc_back.Utils;

import cn.hutool.Hutool;
import cn.hutool.crypto.digest.BCrypt;

import java.util.Objects;

public class SecretUtil {
    public static String getSalt(){
        return BCrypt.gensalt(10);
    }

    public static String EnSecret(String salt,String passWord){
        return BCrypt.hashpw(passWord,salt);
    }

    public static boolean ChSecret(String passWord,String enPassWord){
        return BCrypt.checkpw(passWord,enPassWord)|| Objects.equals(passWord, enPassWord);
    }
}
