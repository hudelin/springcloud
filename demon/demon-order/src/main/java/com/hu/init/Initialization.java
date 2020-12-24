package com.hu.init;

import com.hu.annotation.PayTypeAnnotation;
import com.hu.constant.PayTypeEnum;
import com.hu.context.BaseApplicationContext;
import com.hu.handler.PayHandler;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.target.SingletonTargetSource;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hudelin
 * @date 2020-12-04
 */
@Component
public class Initialization implements InitializingBean {

    public static final Map<String, PayHandler> PAY_STRATEGY_MAP = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
//        Map<String, Object> beansWithAnnotation = BaseApplicationContext.getContext().getBeansWithAnnotation(PayTypeAnnotation.class);
//        for (Object bean : beansWithAnnotation.values()) {
//            PayTypeAnnotation annotation = bean.getClass().getAnnotation(PayTypeAnnotation.class);
//            PAY_STRATEGY_MAP.put(annotation.value().getName(), (PayHandler) bean);
//        }
    }
}
