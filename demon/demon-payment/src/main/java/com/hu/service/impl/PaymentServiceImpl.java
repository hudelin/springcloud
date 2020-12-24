package com.hu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.mapper.PaymentMapper;
import com.hu.pojo.bo.PaymentBO;
import com.hu.pojo.po.Payment;
import com.hu.pojo.vo.PaymentPageVO;
import com.hu.service.PaymentService;
import com.hu.util.CopyUtil;
import com.hu.util.IdFactorySnowFlakeUtil;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private TestImpl testImpl;

    @Override
    public int create(PaymentBO paymentBO) {
        Payment payment = CopyUtil.transToObj(paymentBO, Payment.class);
        int i = paymentMapper.insert(payment);
        return i;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void test() throws Exception {
        System.out.println("payment全局事务，XID = " + RootContext.getXID());
        Random r = new Random();
        Payment build = Payment.builder()
                .serial("测试payment")
                .paymentId(IdFactorySnowFlakeUtil.snowflakeId())
                .price(BigDecimal.valueOf(r.nextInt(100)))
                .discount(BigDecimal.valueOf(r.nextInt(50)))
                .createTime(new Date())
                .updateTime(new Date())
                .deleted("0")
                .build();
        paymentMapper.insert(build);
        testImpl.test();
    }

    @Override
    public Page<Payment> page(PaymentPageVO paymentPageVO) throws Exception {
        Page<Payment> page = new Page<>(paymentPageVO.getCurrent(), paymentPageVO.getSize());
        QueryWrapper<Payment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(Payment::getSerial, paymentPageVO.getSerial());
        Page<Payment> paymentPage = paymentMapper.selectPage1(page, queryWrapper);
//        Page<PaymentBO> paymentBOPage = paymentMapper.selectPageBO(page, queryWrapper);
//        System.out.println(paymentBOPage);
        return paymentPage;
    }
}
