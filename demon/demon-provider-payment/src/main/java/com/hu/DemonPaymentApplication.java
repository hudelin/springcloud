package com.hu;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 支付启动类
 *
 * @author hudelin
 * @date 2020/06/30 13:16
 */
@SpringBootApplication(scanBasePackages = {"com.hu"}, exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@EnableAutoDataSourceProxy
//@EnableOAuth2Sso
public class DemonPaymentApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemonPaymentApplication.class, args);
    }



}
