package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类
 * @author hudelin
 * @date 2020/06/30 13:16
 */
@SpringBootApplication
@EnableEurekaClient
public class DemonPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonPaymentApplication.class, args);
    }
    
}
