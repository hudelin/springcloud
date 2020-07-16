package com.hu.creational.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hudelin
 * @className :Meal
 * @description : 菜单
 * @date: 2020-07-16 14:42
 */
public class Meal {

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public BigDecimal getCost() {
        BigDecimal cost = BigDecimal.valueOf(0);
        for (Item item : items) {
            cost = cost.add(item.price());
        }
        return cost;
    }

    public void showItems() {
        items.stream().forEach(item -> {
            System.out.print("菜名：" + item.name());
            System.out.print("，打包方式：：" + item.packing().pack());
            System.out.println("，价格：" + item.price());
        });
    }

}
