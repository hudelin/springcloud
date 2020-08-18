package com.hu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author : hudelin
 * @className :BusinessMessage
 * @description : 简单业务信息类
 * @date: 2020-07-07 11:08
 */
@Data
@AllArgsConstructor
public class BusinessMessage {

    /**
     * 获取消息的编号
     * @return code
     */
    private Integer code;

    /**
     * 获取消息的内容
     * @return msg
     */
    private String msg;

}