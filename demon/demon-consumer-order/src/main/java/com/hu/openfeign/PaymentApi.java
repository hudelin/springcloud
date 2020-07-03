package com.hu.openfeign;

import com.hu.pojo.entity.Payment;
import com.hu.result.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : hudelin
 * @className :PaymentApi
 * @description : 支付服务fengn调用
 * @date: 2020-07-01 15:27
 */
@FeignClient(value = "demon-payment-service", path = "demon-payment-service")
public interface PaymentApi {

    @RequestMapping(value = "/payment/payment", method = RequestMethod.POST)
    ResultMessage payment(Payment payment);
}
