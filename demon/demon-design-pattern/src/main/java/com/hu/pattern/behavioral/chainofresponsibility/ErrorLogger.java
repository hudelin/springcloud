package com.hu.pattern.behavioral.chainofresponsibility;

/**
 * @author : hudelin
 * @className :ErrorLogger
 * @description : 错误日志
 * @date: 2020-07-20 11:26
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("错误日志：" + message);
    }
}
