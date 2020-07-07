package com.hu.controller;

import com.hu.pojo.dto.LoginDTO;
import com.hu.result.ResultMessage;
import com.hu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param loginDTO
     * @return
     */
    @GetMapping(value = "/login/pwd")
    public ResultMessage login(@RequestBody LoginDTO loginDTO) {
        String accessToken = loginService.loginAdmin(loginDTO);
        return ResultMessage.success(accessToken).message("登录成功");
    }
}
