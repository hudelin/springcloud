package com.hu.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :ColdDrink
 * @description : 冷饮
 * @date: 2020-07-16 14:37
 */
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    /**
     * 价格
     *
     * @return
     */
    @Override
    public abstract BigDecimal price();
}
