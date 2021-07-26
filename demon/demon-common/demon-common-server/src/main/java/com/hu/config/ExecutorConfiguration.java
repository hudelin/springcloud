package com.hu.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author hudelin
 * @date 2021/7/8
 */
@Configuration
@ConfigurationProperties(prefix = "executor")
@Getter
@Setter
public class ExecutorConfiguration {

    /**
     * 核心线程数
     */
    private int corePoolSize = 3;
    /**
     * 最大线程数
     */
    private int maximumPoolSize = 6;
    /**
     * 超过 corePoolSize 线程数量的线程最大空闲时间
     */
    private long keepAliveTime = 2;
    /**
     * 以秒为时间单位
     */
    private TimeUnit unit = TimeUnit.SECONDS;

    /**
     *  队列长度
     */
    private int queueNum = 2;

    /**
     * 队列
     */
    private BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(queueNum);

    @Bean(name = "threadPoolExecutor")
    public ThreadPoolExecutor threadPoolExecutor(){
        return new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
