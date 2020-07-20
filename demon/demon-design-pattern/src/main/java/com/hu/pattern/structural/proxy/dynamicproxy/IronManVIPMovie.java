package com.hu.pattern.structural.proxy.dynamicproxy;

/**
 * @author : hudelin
 * @className :IronManVIPMovie
 * @description :vip实现类
 * @date: 2020-06-17 10:36
 */
public class IronManVIPMovie implements VIPMovie {
    @Override
    public void vipPlay() {
        System.out.println("VI影厅正在播放的电影是《vipmovie》");
    }
}
