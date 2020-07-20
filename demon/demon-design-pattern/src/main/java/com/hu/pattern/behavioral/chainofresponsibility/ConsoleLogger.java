package com.hu.pattern.behavioral.chainofresponsibility;

/**
 * @author : hudelin
 * @className :ConsoleLogger
 * @description : 控制台日志
 * @date: 2020-07-20 11:23
 */
public class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("控制台日志：" + message);
    }
}
