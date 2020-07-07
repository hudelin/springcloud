package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : hudelin
 * @className :DemonSecurityAuthApplication
 * @description : 权限启动类
 * @date: 2020-07-07 09:58
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemonSecurityAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemonSecurityAuthApplication.class, args);
    }
}
