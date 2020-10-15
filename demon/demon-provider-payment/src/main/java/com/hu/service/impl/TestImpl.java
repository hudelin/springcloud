package com.hu.service.impl;

import com.hu.mapper.PaymentMapper;
import com.hu.pojo.po.Payment;
import com.hu.util.IdFactorySnowFlakeUtil;
import io.seata.core.context.RootContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@Service
public class TestImpl {

    @Resource
    private PaymentMapper paymentMapper;

    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void test() throws Exception {
        System.out.println("payment全局事务，XID = " + RootContext.getXID());
        Random r = new Random();
        Payment build = Payment.builder()
                .serial("测试paymentPropagation.REQUIRES_NEW")
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
