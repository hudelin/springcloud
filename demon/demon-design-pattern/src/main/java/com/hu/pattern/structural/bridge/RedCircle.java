package com.hu.pattern.structural.bridge;

/**
 * @author : hudelin
 * @className :RedCircle
 * @description :
 * @date: 2020-07-16 15:55
 */
public class RedCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画红色圆，半径：" + radius + "，圆心：（" + x + "," + y + "）");
    }
}
