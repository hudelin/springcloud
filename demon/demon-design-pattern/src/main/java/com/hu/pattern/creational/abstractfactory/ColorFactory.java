package com.hu.pattern.creational.abstractfactory;

/**
 * @author : hudelin
 * @className :ColorFacrtory
 * @description : 颜色工厂
 * @date: 2020-07-16 10:54
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        Color color = null;
        if ("BLUE".equals(colorType)) {
            color = new Blue();
        }
        if ("RED".equals(colorType)) {
            color = new Red();
        }
        if ("GREEN".equals(colorType)) {
            color = new Green();
        }
        return color;
    }

    @Override
    public Shape getShape(String shapeType) {
        return null;
    }
}
