package com.hu.service.impl;

import com.hu.mapper.PaymentMapper;
import com.hu.pojo.bo.PaymentBO;
import com.hu.pojo.po.Payment;
import com.hu.service.PaymentService;
import com.hu.util.CopyUtil;
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
    public int create(PaymentBO paymentBO) {
        Payment payment = CopyUtil.transToObj(paymentBO, Payment.class);
        int i = paymentMapper.insert(payment);
        return i;
    }
}
