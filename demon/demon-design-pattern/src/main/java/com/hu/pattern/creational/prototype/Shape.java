package com.hu.pattern.creational.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author : hudelin
 * @className :Shape
 * @description : 形状
 * @date: 2020-07-16 10:28
 */
@ToString
public abstract class Shape implements Cloneable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    protected String type;

    /**
     * 画图
     */
    abstract void draw();

    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
