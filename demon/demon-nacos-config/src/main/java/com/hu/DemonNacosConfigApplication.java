package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : hudelin
 * @className :DemonNacosConfigApplication
 * @description : nacos配置启动类
 * @date: 2020-07-03 11:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class DemonNacosConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemonNacosConfigApplication.class, args);
    }
}
