package com.hu.pattern.creational.prototype;


/**
 * @author : hudelin
 * @className :Rectangle
 * @description : 长方形
 * @date: 2020-07-16 10:31
 */
public class Rectangle extends Shape {

    public Rectangle() {
        super.setType("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("Rectangle画长方形");
    }
}
