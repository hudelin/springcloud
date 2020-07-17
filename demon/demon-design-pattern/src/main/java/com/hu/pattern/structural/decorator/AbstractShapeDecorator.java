package com.hu.pattern.structural.decorator;

/**
 * @author : hudelin
 * @className :ShapeDecorator
 * @description : shape抽象装饰类
 * @date: 2020-07-17 11:14
 */
public abstract class AbstractShapeDecorator implements Shape{

    protected Shape decoratedShape;

    public AbstractShapeDecorator(Shape decoratedShape){
        this.decoratedShape=decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}
