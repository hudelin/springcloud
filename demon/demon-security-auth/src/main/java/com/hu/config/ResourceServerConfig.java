package com.hu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author : hudelin
 * @className :ResourceServerConfig
 * @description : 资源服务器配置
 * @date: 2020-07-07 15:25
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("backend-resources").stateless(true);
        resources.authenticationEntryPoint(new AuthExceptionEntryPoint());
    }

}

