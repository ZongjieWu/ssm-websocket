package com.wzj.utils;

import java.util.Random;

// 随机数
public class RandomUtils {

    // 随机个四位数的验证码
    public static String code(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < 4;i++) {
            sb.append(Math.abs(random.nextInt())%10);
        }
        return sb.toString();
    }
}
