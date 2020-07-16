package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :Green
 * @description : 绿色
 * @date: 2020-07-16 10:49
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Green填充绿色");
    }
}
