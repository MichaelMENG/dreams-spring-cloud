package com.dreams.order.server.utils;

import java.util.Random;

/**
 * 1. 随机数生成主键，不适合生产环境.
 */
public class KeyUtil {

    public static synchronized String genuniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
