package com.hu.pattern.creational.builder;

/**
 * @author : hudelin
 * @className :Wrapper
 * @description : 纸包装
 * @date: 2020-07-16 14:31
 */
public class Wrapper implements Packing {

    @Override
    public String pack() {
        return "纸包装";
    }
}
