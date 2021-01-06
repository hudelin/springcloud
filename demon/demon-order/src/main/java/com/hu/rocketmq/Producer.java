package com.hu.rocketmq;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author hudelin
 * @date 2020/12/29
 */
@Component
public class Producer {

    private static final String TOPIC = "DEMON";
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 发送登出消息
     */
    public void sendLogMsg() {
        // 获取请求的ip等信息
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 获取当前用户信息
        rocketMQTemplate.convertAndSend(TOPIC, "test");
    }
}
