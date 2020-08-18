package com.hu.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务异常类
 *
 * @author hudelin
 * @date 2020/7/7 12:37
 */
public class BusinessException extends RuntimeException {

    @Getter
    @Setter
    private BusinessMessage businessMessage;

    public static BusinessException operate() {
        ErrorMsgEnum errorMsgEnum = ErrorMsgEnum.FAIL;
        return createCodeAndMsg(errorMsgEnum.getCode(), errorMsgEnum.getMsg());
    }

    public static BusinessException operate(String msg) {
        ErrorMsgEnum errorMsgEnum = ErrorMsgEnum.FAIL;
        return createCodeAndMsg(errorMsgEnum.getCode(), msg);
    }

    public static BusinessException operate(ErrorMsgEnum errorMsgEnum) {
        return createCodeAndMsg(errorMsgEnum.getCode(), errorMsgEnum.getMsg());
    }

    private static BusinessException createCodeAndMsg(Integer code, String msg) {
        return new BusinessException(new BusinessMessage(code, msg));
    }

    /**
     * 私有化构造器
     * @param businessMessage
     */
    private BusinessException(BusinessMessage businessMessage) {
        this.businessMessage = businessMessage;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

}
