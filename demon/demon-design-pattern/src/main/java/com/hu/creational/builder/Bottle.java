package com.hu.creational.builder;

/**
 * @author : hudelin
 * @className :Bottle
 * @description : 瓶装
 * @date: 2020-07-16 14:32
 */
public class Bottle implements Packing {

    @Override
    public String pack() {
        return "瓶装";
    }
}
