package com.hu.controller;

import com.hu.result.ResultMessage;
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

    @RequestMapping(value = { "/auth/user" }, produces = "application/json")
    public Map<String, Object> user(Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet( user.getAuthorities()));
        System.out.println(passwordEncoder.encode("password"));
        System.out.println(passwordEncoder.encode("secret"));
        return userInfo;
    }

    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public ResultMessage myDetail() {
        Map curUser = (Map) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String userName = (String)curUser.get("username");
        return ResultMessage.success(userName).message("登录成功");
    }

}
