package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : hudelin
 * @className :DemonGatewayApplication
 * @description : 网关启动类
 * @date: 2020-07-02 15:04
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemonGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemonGatewayApplication.class, args);
    }
}
