package com.hu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.oas.annotations.EnableOpenApi;


/**
 * 支付启动类
 *
 * @author hudelin
 * @date 2020/06/30 13:16
 */
@SpringBootApplication(scanBasePackages = {"com.hu"}, exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.hu.mapper")
//@EnableAutoDataSourceProxy
//@EnableOAuth2Sso
@EnableOpenApi
public class DemonPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonPaymentApplication.class, args);
    }



}
