package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :Blue
 * @description :蓝色
 * @date: 2020-07-16 10:47
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Blue填充蓝色");
    }
}
