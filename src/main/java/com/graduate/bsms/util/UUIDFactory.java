package com.graduate.bsms.util;

import java.util.UUID;

/**
 * UUID工厂：提供UUID的获取
 *
 * @author NCJK-L
 * @since 2018-03-16
 */
public class UUIDFactory {

    // 提供UUID的静态方法
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }

}
