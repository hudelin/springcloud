package com.hu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.pojo.bo.PaymentBO;
import com.hu.pojo.po.Payment;
import com.hu.pojo.vo.PaymentPageVO;

/**
 * @author : hudelin
 * @className :PaymentService
 * @description : 支付服务类接口
 * @date: 2020-06-30 15:51
 */
public interface PaymentService {

    int create(PaymentBO paymentBO);

    void test() throws Exception;

    Page<Payment> page(PaymentPageVO paymentPageVO) throws Exception;

}
