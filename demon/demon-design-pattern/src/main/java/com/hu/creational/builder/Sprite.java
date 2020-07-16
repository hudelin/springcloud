package com.hu.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :Pepsi
 * @description :雪碧
 * @date: 2020-07-16 14:40
 */
public class Sprite extends ColdDrink {

    @Override
    public String name() {
        return "雪碧";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(4);
    }
}
