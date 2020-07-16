package com.hu.creational.prototype;

import java.util.Hashtable;

/**
 * @author : hudelin
 * @className :ShapeCache
 * @description : 原型模式，属于创建型模式，通过clone方法实现对象浅拷贝，减少new 消耗时间资源
 * @date: 2020-07-16 11:41
 */
public class ShapeCache {

    private static Hashtable<String, Shape> shapeHashtable = new Hashtable<>(5);

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeHashtable.get(shapeId);
        return (Shape) cachedShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeHashtable.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeHashtable.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeHashtable.put(rectangle.getId(), rectangle);
    }

    public static void main(String[] args) {
        ShapeCache.loadCache();

        Shape circle = ShapeCache.getShape("1");
        System.out.println("复制形状:" + circle.getType());

        Shape square = ShapeCache.getShape("2");
        System.out.println("复制形状:" + square.getType());

        Shape rectangle = ShapeCache.getShape("3");
        System.out.println("复制形状:" + rectangle.getType());

    }

}
