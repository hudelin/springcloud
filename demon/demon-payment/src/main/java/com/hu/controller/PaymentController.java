package com.hu.controller;

import com.hu.exception.BusinessException;
import com.hu.pojo.vo.PaymentPageVO;
import com.hu.result.ResultMessage;
import com.hu.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : hudelin
 * @className :PaymentController
 * @description : 支付控制器
 * @date: 2020-06-30 15:56
 */
@RestController
@RequestMapping("payment")
@Api(tags="用户管理")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @ApiOperation("创建用户")
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
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

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ResultMessage test() throws Exception {
        paymentService.test();
        TimeUnit.SECONDS.sleep(20000);
        return ResultMessage.success().message("payment调用成功");
    }

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public ResultMessage page(@RequestBody @Valid PaymentPageVO paymentPageVO) throws Exception {
        return ResultMessage.success(paymentService.page(paymentPageVO));
    }

    public static void validateParam(Object o) {
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
