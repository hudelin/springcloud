package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : hudelin
 * @className :DemonEurekaApplication
 * @description : 启动类
 * @date: 2020-07-01 14:52
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class DemonConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonConsumerOrderApplication.class, args);
    }

}
