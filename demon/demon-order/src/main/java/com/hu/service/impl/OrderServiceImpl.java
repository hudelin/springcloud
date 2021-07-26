package com.hu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hu.constant.OrderStatusEnum;
import com.hu.mapper.OrderMapper;
import com.hu.pojo.bo.DemonOrderBO;
import com.hu.pojo.po.DemonOrder;
import com.hu.pojo.vo.OrderPageVO;
import com.hu.redisson.RedissonService;
import com.hu.result.ResultMessage;
import com.hu.service.OrderService;
import com.hu.util.IdFactorySnowFlakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hudelin
 * @date 2020/12/4
 */
@Service
@Slf4j(topic = "ORDER")
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Resource
    private ThreadPoolExecutor threadPoolExecutor;

    @Resource
    private RedissonService redissonService;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public ResultMessage submit() throws Exception {
//        String key = (String) redisTemplate.opsForHash().get("channel_" + "SSC20200322181100000231" + "_hash", "channel_key");
        String key="hdl";
        RLock lock = redissonService.getRLock(key);
        try {
            boolean bs = lock.tryLock(1, 10, TimeUnit.SECONDS);
            if (bs) {
                log.info("进入业务代码: " + key);
                // 业务代码
                DemonOrder demonOrder = DemonOrder.builder()
                        .orderId("DL" + IdFactorySnowFlakeUtil.snowflakeId())
                        .orderStatus(OrderStatusEnum.ORDER_COMMIT.getName())
                        .build();
                orderMapper.insert(demonOrder);

                threadPoolExecutor.submit(() -> {
                    System.out.println("int");
                });

                redissonService.unlock(lock);
            } else {
                Thread.sleep(30000);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("", e);
        }finally {
            redissonService.unlock(lock);
        }

        return ResultMessage.success();
    }

    @Override
    public Page<DemonOrderBO> listOrder(OrderPageVO orderPageVO) throws Exception {
        Page<DemonOrder> page = new Page<>(orderPageVO.getCurrent(), orderPageVO.getSize());
        QueryWrapper<DemonOrder> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotBlank(orderPageVO.getOrderId())){
            queryWrapper.lambda().like(DemonOrder::getOrderId, orderPageVO.getOrderId());
        }
        Page<DemonOrderBO> orderPage = orderMapper.selectPage1(page, queryWrapper);
        return orderPage;
    }
}
