package com.hu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : hudelin
 * @className :ConfigController
 * @description : 配置控制器
 * @date: 2020-07-03 11:03
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }

    public static int countDigitOne(int n) {
        int count = 0;
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int a = i;
            int counti = 0;
            while (a > 0) {
                if (map.get(i) != null && map.get(i)!=00) {
                    count += map.get(i);
                    a=0;
                } else {
                    if (a % 10 == 1) {
                        count++;
                        counti++;
                    }
                    a /= 10;
                }
                map.put(i,counti);
            }
        }
        return count;



    }

    public static void main(String[] args) {
        System.out.println(countDigitOne(13));
    }


}
