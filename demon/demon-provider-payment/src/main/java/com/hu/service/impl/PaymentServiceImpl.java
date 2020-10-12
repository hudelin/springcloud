package com.hu.service.impl;

import com.hu.mapper.PaymentMapper;

import com.hu.pojo.bo.PaymentBO;
import com.hu.pojo.po.Payment;
import com.hu.service.PaymentService;
import com.hu.util.CopyUtil;
import com.hu.util.IdFactorySnowFlakeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * @author : hudelin
 * @className :PaymentImpl
 * @description : 支付服务类接口实现
 * @date: 2020-06-30 15:52
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    @Override
    public int create(PaymentBO paymentBO) {
        Payment payment = CopyUtil.transToObj(paymentBO, Payment.class);
        int i = paymentMapper.insert(payment);
        return i;
    }

    @Override
    public void test() {

        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            Payment build = Payment.builder()
                    .serial("")
                    .paymentId(IdFactorySnowFlakeUtil.snowflakeId())
                    .price(BigDecimal.valueOf(r.nextInt(100)))
                    .discount(BigDecimal.valueOf(r.nextInt(50)))
                    .createTime(new Date())
                    .updateTime(new Date())
                    .deleted("0")
                    .build();
            paymentMapper.insert(build);
        }

    }
}
