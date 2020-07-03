package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : hudelin
 * @className :DemonNacosProviderApplication
 * @description : nacos服务提供者启动类
 * @date: 2020-07-03 10:33
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemonNacosProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonNacosProviderApplication.class, args);
    }

}
