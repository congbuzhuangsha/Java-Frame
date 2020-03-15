package com.yxj.ssm_demo.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Auther: yangxiaojie
 * @Date: 2020/3/14
 * @version: 1.0
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd = encodePassword(password);
        //$2a$10$HwpDMeQhnVg4j7RtEvLsleD.QYqZsquUHmZCP/30lubUZ5lU.P11m
        System.out.println(pwd);
        System.out.println(pwd.length());
    }
}
