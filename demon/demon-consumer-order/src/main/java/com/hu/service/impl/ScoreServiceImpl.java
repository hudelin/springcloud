package com.hu.service.impl;

import com.hu.mapper.ScoreMapper;
import com.hu.openfeign.PaymentApi;
import com.hu.pojo.po.Score;
import com.hu.service.ScoreService;
import com.hu.util.IdFactorySnowFlakeUtil;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
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
public class ScoreServiceImpl implements ScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    @Autowired
    private PaymentApi paymentApi;

    @Override
    @GlobalTransactional
    @Transactional(rollbackFor = Exception.class)
    public void test() throws Exception {
        System.out.println("开始全局事务，XID = " + RootContext.getXID());
        Random r = new Random();
        paymentApi.test();
        Score build = Score.builder()
                .id(IdFactorySnowFlakeUtil.snowflakeId())
                .course("456")
                .score(10)
                .stuId("123")
                .build();
        scoreMapper.insert(build);

//        int i =10/0;
    }
}
