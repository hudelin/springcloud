package com.hu.controller;

import com.hu.annotation.IgnoreTokenAuth;
import com.hu.pojo.dto.PasswordLoginDTO;
import com.hu.pojo.vo.LoginSuccessVO;
import com.hu.result.ResultMessage;
import com.hu.service.LoginService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author : hudelin
 * @className :LoginAdminController
 * @description : 用户登录控制器
 * @date: 2020-07-07 10:29
 */
@RestController
@RequestMapping(value = "/admin/user")
public class LoginAdminController {

    @Resource
    private LoginService loginService;

    /**
     * 后台用户登录
     * @param passwordLoginDTO
     * @return
     */
    @IgnoreTokenAuth
    @GetMapping(value = "/login/pwd")
    public ResultMessage login(@RequestBody PasswordLoginDTO passwordLoginDTO) {
        LoginSuccessVO accessToken = loginService.pwdLogin(passwordLoginDTO);
        return ResultMessage.success(accessToken).message("登录成功");
    }
}
