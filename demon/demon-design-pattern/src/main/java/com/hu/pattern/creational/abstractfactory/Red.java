package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :Red
 * @description :红色
 * @date: 2020-07-16 10:48
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Red填充红色");
    }
}
