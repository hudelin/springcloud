package com.hu.service.impl;

import com.hu.constant.OrderStatusEnum;
import com.hu.mapper.OrderMapper;
import com.hu.pojo.po.DemonOrder;
import com.hu.result.ResultMessage;
import com.hu.service.OrderService;
import com.hu.util.DateTimeUtil;
import com.hu.util.IdFactorySnowFlakeUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hudelin
 * @date 2020/12/4
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Override
    public ResultMessage submit() throws Exception {
        DemonOrder demonOrder = DemonOrder.builder()
                .orderId("")
                .orderStatus(OrderStatusEnum.ORDER_COMMIT.getName())
                .build();
        orderMapper.insert(demonOrder);
        return null;
    }
}
