package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : hudelin
 * @className :DemonEurekaApplication
 * @description : 启动类
 * @date: 2020-07-01 14:52
 */
@SpringBootApplication
@EnableEurekaServer
public class DemonEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonEurekaApplication.class, args);
    }

}
