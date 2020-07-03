package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Sentinel启动类
 * @author hudelin
 * @date 2020/06/30 13:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemonSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonSentinelApplication.class, args);
    }
    
}
