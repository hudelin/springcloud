package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :AbstractFactory
 * @description : 抽象类来获取工厂
 * @date: 2020-07-16 10:50
 */
public abstract class AbstractFactory {

    /**
     * 获取颜色工厂
     *
     * @param colorType
     * @return
     */
    public abstract Color getColor(String colorType);

    /**
     * 获取形状工厂
     *
     * @param shapeType
     * @return
     */
    public abstract Shape getShape(String shapeType);
}
