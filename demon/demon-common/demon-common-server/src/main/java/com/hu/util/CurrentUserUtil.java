//package com.hu.util;
//
//import com.alibaba.fastjson.JSON;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//import java.util.LinkedHashMap;
//
///**
// * 当前用户信息工具类
// * @author raojing
// * @date 2019/12/6 23:13
// */
//public class CurrentUserUtil {
//
//    /**
//     * 获取当前用户信息（json格式）
//     * @return
//     */
//    public static String getCurrentUserInfoJsonFormat(){
//        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
////        OAuth2Authentication auth2Authentication  = (OAuth2Authentication)authentication;
////        LinkedHashMap details = (LinkedHashMap)auth2Authentication.getUserAuthentication().getDetails();
////        LinkedHashMap principal = (LinkedHashMap)details.get("principal");
////        return JSON.toJSONString(principal);
//        return null;
//    }
//
//}
