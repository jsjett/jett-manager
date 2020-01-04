package com.jett.jettmanager.utils;

import java.util.Random;

public class KeyUtils {
    // 生成不相同的key
    public static String genUniqueKey(){
        Random random = new Random();

        Integer number = random.nextInt(900000)+1000000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
