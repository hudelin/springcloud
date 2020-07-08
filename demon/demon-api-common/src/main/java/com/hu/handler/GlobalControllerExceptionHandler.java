package com.hu.handler;

import com.hu.exception.BusinessException;
import com.hu.exception.BusinessMessage;
import com.hu.result.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : hudelin
 * @className :GlobalControllerExceptionHandler
 * @description : 全局异常处理类
 * @date: 2020-07-08 17:09
 */
@Slf4j(topic = "EXCEPTION_LOG")
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    /**
     * 业务异常处理器
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(BusinessException.class)
    public ResultMessage businessExceptionHandler(BusinessException e) {
        log.info("BusinessException ---> {}", e.getMessage());
        BusinessMessage businessMessage = e.getBusinessMessage();
        return ResultMessage.build(businessMessage.getCode(), businessMessage.getMsg());
    }

    /**
     * 其他异常处理器
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(Exception.class)
    public ResultMessage defaultExceptionHandler(Exception e) {
        log.info("Exception ---> {}", e.getMessage());
        return ResultMessage.fail().message("系统异常，请稍后重试");
    }

    /**
     * 处理请求方式错误引起的异常
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultMessage errorRequestMethod(HttpRequestMethodNotSupportedException e) {
        log.info("HttpRequestMethodNotSupportedException ---> {}", e.getMessage());
        return ResultMessage.fail().message(e.getMessage());
    }
}
