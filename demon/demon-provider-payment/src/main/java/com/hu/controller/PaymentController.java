package com.hu.controller;

import com.hu.pojo.entity.Payment;
import com.hu.result.ResultMessage;
import com.hu.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author : hudelin
 * @className :PaymentController
 * @description : 支付控制器
 * @date: 2020-06-30 15:56
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value = "/payment",method = RequestMethod.POST)
    public ResultMessage payment(@RequestBody Payment payment) {
//        try{
//            TimeUnit.SECONDS.sleep(2);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        return ResultMessage.success().message("payment调用成功");
    }
}
