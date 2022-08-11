//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.corrin.certshare.utils;

import javax.servlet.http.HttpServletRequest;

public final class UrlPrefixUtil {
    private UrlPrefixUtil() {
    }

    public static String getUrlPrefix(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getHeader("host");
    }
}
