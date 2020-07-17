package com.hu.pattern.structural.flyweight;

import com.hu.pattern.structural.facade.Shape;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hudelin
 * @className :Circle
 * @description : 圆形
 * @date: 2020-07-16 10:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Circle implements Shape {

    private String color;
    private int x;
    private int y;
    private int radius;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println("Circle画圆+：" + this);
    }
}
