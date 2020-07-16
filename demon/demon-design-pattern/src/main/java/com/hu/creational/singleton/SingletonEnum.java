package com.hu.creational.singleton;

/**
 * @author : hudelin
 * @className :SingletonEnum
 * @description : 单例模式枚举
 * @date: 2020-07-16 10:20
 */
public enum SingletonEnum {
    /**
     * 利用枚举的特性，让JVM来帮我们保证线程安全和单一实例的问题
     */
    INSTANCE;

    public void whateverMethod() {
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.whateverMethod();
    }

}
