package com.graduate.bsms.util;

import com.graduate.bsms.pojo.Page;

public class PageUtil {
    public static Page getPage(String pageCurrent, String pageSize) {
        return getPage(Integer.parseInt(pageCurrent), Integer.parseInt(pageSize));
    }

    public static Page getPage(int pageCurrent, int pageSize) {
        return new Page((pageCurrent - 1) * pageSize, pageSize);
    }
}
