package com.hu.handler;

import com.hu.exception.BusinessException;
import com.hu.exception.BusinessMessage;
import com.hu.result.ResultMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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
     *
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(BusinessException.class)
    public ResultMessage businessExceptionHandler(BusinessException e) {
        BusinessMessage businessMessage = e.getBusinessMessage();
        log.info("BusinessException ---> {}", businessMessage.getMsg());
        return ResultMessage.build(businessMessage.getCode(), businessMessage.getMsg());
    }

    /**
     * 其他异常处理器
     *
     * @param e Exception
     * @return ApiResult
     */
    @ExceptionHandler(Exception.class)
    public ResultMessage defaultExceptionHandler(Exception e) {
        log.info("Exception ---> {}", e.getMessage());
        return ResultMessage.fail().message("系统异常，请稍后重试");
    }

    /**
     * Valid入参校验异常处理器
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultMessage methodArgumentNotValidExceptionHandler(Exception e) {
        MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        FieldError error = fieldErrors.get(0);
        log.info("MethodArgumentNotValidException ---> {}", error.getDefaultMessage());
        return ResultMessage.fail().message(error.getDefaultMessage());
    }

    /**
     * 处理请求方式错误引起的异常
     *
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultMessage errorRequestMethod(HttpRequestMethodNotSupportedException e) {
        log.info("HttpRequestMethodNotSupportedException ---> {}", e.getMessage());
        return ResultMessage.fail().message(e.getMessage());
    }
}
