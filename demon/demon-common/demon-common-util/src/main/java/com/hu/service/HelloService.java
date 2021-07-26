package com.hu.service;

import com.hu.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author hudelin
 * @date 2021/3/2
 */
public class HelloService {

    @Autowired
    private HelloProperties helloProperties;

    public String sayHello(String userName){
        return helloProperties.getPrefix() + "："+userName+">"+helloProperties.getSuffix();
    }

}
