package com.hu.creational.prototype;


/**
 * @author : hudelin
 * @className :Circle
 * @description : 圆形
 * @date: 2020-07-16 10:30
 */
public class Circle extends Shape {

    public Circle() {
        super.setType("Circle");
    }

    @Override
    public void draw() {
        System.out.println("Circle画圆");
    }
}
