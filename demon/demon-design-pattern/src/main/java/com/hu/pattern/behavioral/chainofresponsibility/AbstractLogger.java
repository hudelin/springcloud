package com.hu.pattern.behavioral.chainofresponsibility;

import lombok.Setter;

/**
 * @author : hudelin
 * @className :AbstractLogger
 * @description : 抽象日志类
 * @date: 2020-07-20 11:17
 */
public abstract class AbstractLogger {

    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    @Setter
    protected AbstractLogger nextLogger;

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    /**
     * 写消息
     *
     * @param message
     */
    abstract protected void write(String message);

}
