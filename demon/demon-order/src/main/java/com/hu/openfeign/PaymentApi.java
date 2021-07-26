package com.hu.openfeign;

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
@FeignClient(value = "demon-payment", path = "demon-payment")
public interface PaymentApi {

    @RequestMapping(value = "/payment/test", method = RequestMethod.POST)
    ResultMessage test();
}
