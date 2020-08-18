package com.hu.mapper;

import com.hu.pojo.po.Payment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : hudelin
 * @className :PaymentDao
 * @description : 支付类dao
 * @date: 2020-06-30 15:30
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

    int create(Payment payment);



}
