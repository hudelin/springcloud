package com.hu.service;

import com.hu.pojo.bo.PaymentBO;

/**
 * @author : hudelin
 * @className :PaymentService
 * @description : 支付服务类接口
 * @date: 2020-06-30 15:51
 */
public interface PaymentService {

    int create(PaymentBO paymentBO);

}
