package com.hu.pattern.creational.factory;

/**
 * @author : hudelin
 * @className :Square
 * @description : 正方形
 * @date: 2020-07-16 10:29
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square画正方形");
    }
}
