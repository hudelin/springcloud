package com.hu.pattern.structural.bridge;

/**
 * @author : hudelin
 * @className :GreenCircle
 * @description :画绿色圆
 * @date: 2020-07-16 15:53
 */
public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("画绿色圆，半径：" + radius + "，圆心：（" + x + "," + y + "）");
    }
}
