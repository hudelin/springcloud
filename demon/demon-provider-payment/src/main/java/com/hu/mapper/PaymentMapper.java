package com.hu.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.pojo.bo.PaymentBO;
import com.hu.pojo.po.Payment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : hudelin
 * @className :PaymentDao
 * @description : 支付类dao
 * @date: 2020-06-30 15:30
 */
public interface PaymentMapper extends BaseMapper<Payment> {

    @Select("SELECT serial,payment_id FROM payment ${ew.customSqlSegment} ")
    Page<Payment> selectPage1(Page<Payment> page, @Param(Constants.WRAPPER) Wrapper wrapper);

}
