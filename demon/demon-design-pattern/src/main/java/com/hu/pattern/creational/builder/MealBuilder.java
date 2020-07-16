package com.hu.pattern.creational.builder;

/**
 * @author : hudelin
 * @className :MealBuilder
 * @description : 菜单设计菜,属于创建型模式,使用多个简单的对象一步一步构建成一个复杂的对象
 * @date: 2020-07-16 14:49
 */
public class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Sprite());
        return meal;
    }

    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMal = mealBuilder.prepareVegMeal();
        System.out.println("蔬菜汉堡");
        vegMal.showItems();
        System.out.println("总价格：" + vegMal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("肉汉堡");
        vegMal.showItems();
        System.out.println("总价格：" + nonVegMeal.getCost());
    }

}
