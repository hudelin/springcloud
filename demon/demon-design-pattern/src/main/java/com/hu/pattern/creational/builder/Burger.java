package com.hu.pattern.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :Burger
 * @description : 堡
 * @date: 2020-07-16 14:32
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 价格
     *
     * @return
     */
    @Override
    public abstract BigDecimal price();
}
