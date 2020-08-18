package com.even.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 北方、
 * @title: RequestUtil
 * @projectName sc
 * @description: TODO
 * @date 2020/8/2 11:11
 */
public class RequestUtil {

    public static String getIP(HttpServletRequest request){
        String remoteAddr = request.getRemoteAddr();
        String forwarded = request.getHeader("X-Forwarded-For");
        String realIp = request.getHeader("X-Real-IP");
        String ip = null;
        if (realIp == null) {
            if (forwarded == null) {
                ip = remoteAddr;
            } else {
                ip = remoteAddr + "/" + forwarded;
            }
        } else {
            if (realIp.equals(forwarded)) {
                ip = realIp;
            } else {
                ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
            }
        }
        return ip;
    }

    public static String getServerName(HttpServletRequest request){
        String name = request.getHeader("X-ServerName");
        return name;
    }
}
