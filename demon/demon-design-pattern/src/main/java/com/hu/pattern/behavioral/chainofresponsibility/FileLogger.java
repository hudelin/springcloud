package com.hu.pattern.behavioral.chainofresponsibility;

/**
 * @author : hudelin
 * @className :FileLogger
 * @description : 文件日志
 * @date: 2020-07-20 11:28
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("文件日志：" + message);
    }
}
