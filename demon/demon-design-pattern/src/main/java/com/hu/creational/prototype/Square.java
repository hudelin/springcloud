package com.hu.creational.prototype;


/**
 * @author : hudelin
 * @className :Square
 * @description : 正方形
 * @date: 2020-07-16 10:29
 */
public class Square extends Shape {

    public Square() {
        super.setType("Square");
    }


    @Override
    public void draw() {
        System.out.println("Square画正方形");
    }
}
