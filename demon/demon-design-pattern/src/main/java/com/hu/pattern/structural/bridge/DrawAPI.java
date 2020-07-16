package com.hu.pattern.structural.bridge;

/**
 * @author : hudelin
 * @className :DrawAPI
 * @description :DrawAPI
 * @date: 2020-07-16 15:51
 */
public interface DrawAPI {
    /**
     * 根据半径和圆心（x,y）画圆
     * @param radius
     * @param x
     * @param y
     */
    void drawCircle(int radius,int x,int y);
}
