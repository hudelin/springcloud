package com.hu.util;

/**
 * 检查终端类型工具类
 *
 * @author hudelin
 * @date 2020/8/3 22:25
 */
public class CheckAgentUtil {
    
    /**
     * 定义移动端请求的所有可能类型
     */
    private final static String[] AGENT = {"Android", "iPhone", "iPod", "iPad", "Windows Phone", "MQQBrowser"};

    /**
     * 判断终端是否为手机端
     * @param ua
     * @return
     */
    public static boolean checkAgentIsMobile(String ua) {
        boolean flag = false;
        boolean isMobile = !ua.contains("Windows NT") || (ua.contains("Windows NT") && ua.contains("compatible; MSIE 9.0;"));
        if (isMobile) {
            // 排除 苹果桌面系统
            if (!ua.contains("Windows NT") && !ua.contains("Macintosh")) {
                for (String item : AGENT) {
                    if (ua.contains(item)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

}
