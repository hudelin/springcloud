package com.hu.pattern.structural.bridge;

/**
 * @author : hudelin
 * @className :Shape
 * @description : 形状
 * @date: 2020-07-16 15:56
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    /**
     * 绘画
     */
    public abstract void draw();
}
