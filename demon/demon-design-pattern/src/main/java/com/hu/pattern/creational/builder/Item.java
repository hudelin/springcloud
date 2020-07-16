package com.hu.pattern.creational.builder;

import java.math.BigDecimal;

/**
 * @author : hudelin
 * @className :Item
 * @description : 食物条目和包装接口
 * @date: 2020-07-16 14:28
 */
public interface Item {

    /**
     * 名称
     *
     * @return
     */
    String name();

    /**
     * 打包方式
     *
     * @return
     */
    Packing packing();

    /**
     * 价格
     *
     * @return
     */
    BigDecimal price();

}
