package com.rum.ksc_back;

import cn.hutool.crypto.digest.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.IfProfileValue;

import java.util.*;

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
        String[] words = {"cd", "ef", "a"};
        System.out.println(maxPalindromesAfterOperations(words));
    }

    public static int maxPalindromesAfterOperations(String[] words) {
        int[] count = new int[26];
        int sum = 0;
        int pair = 0;
        int[] len = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            len[i] = words[i].length();
            sum += words[i].length();
            for (int j = 0; j < words[i].length(); j++) {
                count[words[i].charAt(j) - 'a']++;
            }
        }
        for (int j : count) {
            if (j == 0) continue;
            pair += j / 2;
        }
        Arrays.sort(len);
        for (int i = 0; i < len.length; i++) {
            sum -= len[i];
            pair -= len[i] / 2;
            if (pair < 0 || sum < 0) {
                return i;
            }
        }
        return words.length;
    }
}
