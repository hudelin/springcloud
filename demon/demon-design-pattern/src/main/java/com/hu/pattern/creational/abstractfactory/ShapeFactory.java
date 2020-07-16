package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :ShapeFactory
 * @description : 形状工厂
 * @date: 2020-07-16 10:52
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
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
}
