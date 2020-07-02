package com.hu.service.impl;

import com.hu.mapper.PaymentMapper;

import com.hu.pojo.entity.Payment;
import com.hu.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : hudelin
 * @className :PaymentImpl
 * @description : 支付服务类接口实现
 * @date: 2020-06-30 15:52
 */
@Service
public class PaymentImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(Payment payment) {
        int i = paymentMapper.create(payment);
        return i;
    }
}
