package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :Circle
 * @description : 圆形
 * @date: 2020-07-16 10:30
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle画圆");
    }
}
