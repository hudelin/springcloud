package com.hu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hudelin
 * @className :AuthController
 * @description : 权限控制器
 * @date: 2020-07-07 10:01
 */
@RestController
public class AuthController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

}
