package com.hu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author hudelin
 * @date 2021/3/2
 */
@SpringBootApplication(scanBasePackages = {"com.hu"},exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.hu.mapper")
public class DemonProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonProductApplication.class, args);
    }
}
