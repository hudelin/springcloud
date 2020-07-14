package com.hu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : hudelin
 * @className :BCryptPasswordEncoder
 * @description :
 * @date: 2020-07-14 16:19
 */
@Configuration
public class PasswordEncoderConfig {

    /**
     * 配置默认的加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
