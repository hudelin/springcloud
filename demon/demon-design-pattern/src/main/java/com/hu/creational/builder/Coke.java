package com.hu.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :Coke
 * @description : 可乐
 * @date: 2020-07-16 14:40
 */
public class Coke extends ColdDrink {

    @Override
    public String name() {
        return "可乐";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(5);
    }
}
