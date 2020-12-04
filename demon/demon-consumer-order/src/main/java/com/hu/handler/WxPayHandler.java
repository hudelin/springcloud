package com.hu.handler;


import com.hu.annotation.PayTypeAnnotation;
import com.hu.constant.PayTypeEnum;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hudelin
 * @date 2020-12-04
 */
@Component
@PayTypeAnnotation(PayTypeEnum.WX_PAY)
public class WxPayHandler extends PayHandler {

    @Transactional(rollbackFor = Exception.class)
    public void test(){

    }

}
