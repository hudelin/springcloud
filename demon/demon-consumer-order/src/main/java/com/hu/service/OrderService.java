package com.hu.service;

import com.hu.result.ResultMessage;

/**
 * @author hudelin
 * @date 2020/12/4
 */
public interface OrderService {


    /**
     * 提交订单
     *
     * @return
     * @throws Exception
     */
    ResultMessage submit() throws Exception;

}
