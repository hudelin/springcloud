package com.hu.creational.factory;

/**
 * @author : hudelin
 * @className :ShapeFactory
 * @description : 形状工厂,工厂模式，属于创建型模式，通过使用一个共同的接口来指向新创建的对象
 * @date: 2020-07-16 10:34
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        Shape shape = null;
        if ("CIRCLE".equals(shapeType)) {
            shape = new Circle();
        }
        if ("RECTANGLE".equals(shapeType)) {
            shape = new Rectangle();
        }
        if ("SQUARE".equals(shapeType)) {
            shape = new Square();
        }
        return shape;
    }

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        //画圆形
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        //画长方形
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
        //画正方形
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

    }

}
