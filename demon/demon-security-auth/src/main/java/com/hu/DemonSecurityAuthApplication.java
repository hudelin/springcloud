package com.hu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author : hudelin
 * @className :DemonSecurityAuthApplication
 * @description : 权限启动类
 * @date: 2020-07-07 09:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAuthorizationServer
//@EnableResourceServer
public class DemonSecurityAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemonSecurityAuthApplication.class, args);
    }
}
