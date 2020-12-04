package com.hu.controller;

import com.hu.result.ResultMessage;
import com.hu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    private OrderService orderService;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public ResultMessage submit() throws Exception {
        return ResultMessage.success(orderService.submit());
    }


    @RequestMapping(value = "/payment/test",method = RequestMethod.POST)
    public ResultMessage payment() throws Exception {
//        scoreService.test();
//        String key = (String) redisTemplate.opsForHash().get("channel_" + "SSC20200322181100000231" + "_hash", "channel_key");
//        System.out.println(Initialization.PAY_STRATEGY_MAP);

        return ResultMessage.success().message("key");
    }
}
