package com.hu.controller;

import com.hu.exception.BusinessException;
import com.hu.pojo.bo.PaymentBO;
import com.hu.result.ResultMessage;
import com.hu.service.PaymentService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

/**
 * @author : hudelin
 * @className :PaymentController
 * @description : 支付控制器
 * @date: 2020-06-30 15:56
 */
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @RequestMapping(value = "/payment",method = RequestMethod.GET)
    public ResultMessage payment() {
//        validateParam(payment);
//        try{
//            TimeUnit.SECONDS.sleep(10);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        paymentService.create(paymentBO);
        return ResultMessage.success().message("payment调用成功");
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public ResultMessage test() throws Exception {
        System.out.println("payment全局事务，XID = " + RootContext.getXID());
        paymentService.test();
        return ResultMessage.success().message("payment调用成功");
    }


    public static void validateParam(Object o)  {
        Set<ConstraintViolation<Object>> validResult = Validation.buildDefaultValidatorFactory().getValidator().validate(o);
        if (null != validResult && validResult.size() > 0) {
            for (ConstraintViolation<Object> constraintViolation : validResult) {
                if (!org.springframework.util.StringUtils.isEmpty(constraintViolation.getMessage())) {
                    throw BusinessException.operate(constraintViolation.getMessage());
                }
            }
        }
    }
}
