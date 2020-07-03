package com.hu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : hudelin
 * @className :FlowLimitController
 * @description : 限流
 * @date: 2020-07-03 16:11
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "--------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "--------testB";
    }
}
