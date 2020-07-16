package com.hu.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :VegBurger
 * @description : 素堡
 * @date: 2020-07-16 14:35
 */
public class VegBurger extends Burger {

    @Override
    public String name() {
        return "素堡";
    }

    @Override
    public BigDecimal price() {
        return BigDecimal.valueOf(20);
    }
}
