package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :Rectangle
 * @description : 长方形
 * @date: 2020-07-16 10:31
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Rectangle画长方形");
    }
}
