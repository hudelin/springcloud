package com.hu.controller;

import com.hu.openfeign.PaymentApi;
import com.hu.pojo.entity.Payment;
import com.hu.result.ResultMessage;
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
    private PaymentApi paymentApi;

    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public ResultMessage payment(@RequestBody Payment payment) {

        return paymentApi.payment(payment);
    }
}
