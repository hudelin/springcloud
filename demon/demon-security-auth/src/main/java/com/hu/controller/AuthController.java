package com.hu.controller;

import com.hu.annotation.IgnoreTokenAuth;
import com.hu.pojo.bo.PaymentBO;
import com.hu.result.ResultMessage;
import com.hu.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : hudelin
 * @className :AuthController
 * @description : 权限控制器
 * @date: 2020-07-07 10:01
 */
@RestController
public class AuthController {

    @Resource
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = { "/auth/user" }, produces = "application/json",method = RequestMethod.POST)
    public Map<String, Object> user(Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet( user.getAuthorities()));
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("secret"));
        return userInfo;
    }

    @RequestMapping(value = "/my", method = RequestMethod.POST)
    public ResultMessage myDetail() {
//        Map curUser = (Map) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getPrincipal();
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
//        String userName = (String)curUser.get("username");
        return ResultMessage.success(principal).message("登录成功");
    }

    @IgnoreTokenAuth
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResultMessage test() {
        int i = paymentService.create(PaymentBO.builder().paymentId(123L).serial("123").build());
        return ResultMessage.success(i).message("登录成功");
    }




}
