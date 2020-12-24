package com.hu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.pojo.bo.DemonOrderBO;
import com.hu.pojo.vo.OrderPageVO;
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

    /**
     * 提交订单
     *
     * @return
     * @throws Exception
     */
    Page<DemonOrderBO> listOrder(OrderPageVO orderPageVO) throws Exception;

}
