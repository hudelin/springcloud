package com.hu.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :ChickenBurger
 * @description : 鸡肉堡
 * @date: 2020-07-16 14:36
 */
public class ChickenBurger extends Burger {

    @Override
    public String name() {
        return "鸡肉堡";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(30);
    }
}
