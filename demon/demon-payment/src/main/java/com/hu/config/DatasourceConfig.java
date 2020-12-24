//package com.hu.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * @author : hudelin
// * @className :DatasourceConfig
// * @description : 数据库配置类
// * @date: 2020-07-03 23:44
// */
//
//@Configuration
//public class DatasourceConfig {
//
//    @Value("${spring.datasource.url}")
//    private String datasourceUrl;
//    @Value("${spring.datasource.username}")
//    private String datasourceUsername;
//    @Value("${spring.datasource.password}")
//    private String datasourcePassword;
//
//    @Bean
//    public DataSource getDataSource() {
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(datasourceUrl);
//        dataSource.setUsername(datasourceUsername);
//        dataSource.setPassword(datasourcePassword);
//        return dataSource;
//    }
//}
