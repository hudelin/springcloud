package com.hu;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author : hudelin
 * @className :DemonEurekaApplication
 * @description : 订单启动类
 * @date: 2020-07-01 14:52
 */
@SpringBootApplication(scanBasePackages = {"com.hu"},exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.hu.mapper")
//@EnableAutoDataSourceProxy
public class DemonConsumerOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonConsumerOrderApplication.class, args);
    }

}
