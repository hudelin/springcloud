package com.hu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.constant.OrderStatusEnum;
import com.hu.mapper.OrderMapper;
import com.hu.pojo.bo.DemonOrderBO;
import com.hu.pojo.po.DemonOrder;
import com.hu.pojo.vo.OrderPageVO;
import com.hu.result.ResultMessage;
import com.hu.service.OrderService;
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
                .orderId("DL"+IdFactorySnowFlakeUtil.snowflakeId())
                .orderStatus(OrderStatusEnum.ORDER_COMMIT.getName())
                .build();
        orderMapper.insert(demonOrder);
        return ResultMessage.success(demonOrder);
    }

    @Override
    public Page<DemonOrderBO> listOrder(OrderPageVO orderPageVO) throws Exception {
        Page<DemonOrder> page = new Page<>(orderPageVO.getCurrent(), orderPageVO.getSize());
        QueryWrapper<DemonOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().like(DemonOrder::getOrderId, orderPageVO.getOrderId());
        Page<DemonOrderBO> orderPage = orderMapper.selectPage1(page, queryWrapper);
//        Page<PaymentBO> paymentBOPage = paymentMapper.selectPageBO(page, queryWrapper);
//        System.out.println(paymentBOPage);
        return orderPage;
    }
}
