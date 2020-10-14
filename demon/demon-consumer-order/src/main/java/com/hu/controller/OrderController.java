package com.hu.controller;

import com.hu.result.ResultMessage;
import com.hu.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author : hudelin
 * @className :OrderController
 * @description : 订单控制器
 * @date: 2020-07-01 15:33
 */
@RestController
@RequestMapping("order")
public class OrderController {



    @Autowired
    private ScoreService scoreService;

    @RequestMapping(value = "/payment/test",method = RequestMethod.POST)
    public ResultMessage payment() throws Exception {
        scoreService.test();
        return ResultMessage.success().message("order调用成功");
    }
}
