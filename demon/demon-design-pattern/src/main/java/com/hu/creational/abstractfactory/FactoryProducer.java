package com.hu.creational.abstractfactory;


/**
 * @author : hudelin
 * @className :FactoryProducer
 * @description : 工厂创造器，抽象工厂模式，属于创建型模式
 * @date: 2020-07-16 10:56
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String choice) {
        AbstractFactory abstractFactory = null;
        if ("SHAPE".equals(choice)) {
            abstractFactory = new ShapeFactory();
        } else if ("COLOR".equals(choice)) {
            abstractFactory = new ColorFactory();
        }
        return abstractFactory;
    }

    public static void main(String[] args) {
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //画圆形
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();
        //画长方形
        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();
        //画正方形
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //填充蓝色
        Color blue = colorFactory.getColor("BLUE");
        blue.fill();
        //填充蓝色
        Color red = colorFactory.getColor("RED");
        red.fill();
        //填充蓝色
        Color green = colorFactory.getColor("GREEN");
        green.fill();
    }

}
