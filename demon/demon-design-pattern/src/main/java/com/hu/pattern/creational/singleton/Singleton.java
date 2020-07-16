package com.hu.pattern.creational.singleton;

/**
 * @author : hudelin
 * @className :Singleton
 * @description : 单例模式,属于创建型模式，保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * @date: 2020-07-16 09:53
 */
public class Singleton {

    /**
     * 构造函数私有化，不能被实例化
     */
    private Singleton() {
    }

    /**
     * 懒汉模式
     * 没有加锁 synchronized，所以严格意义上它并不算单例模式
     * 是否lazy初始化：是
     * 是否线程安全：否
     */
    private static Singleton singletonLazy;

    public static Singleton getSingletonLazy() {
        if (singletonLazy == null) {
            singletonLazy = new Singleton();
        }
        return singletonLazy;
    }

    /**
     * 懒汉模式，添加synchronized，同步锁
     * 是否lazy初始化：是
     * 是否线程安全：是
     */
    private static Singleton singletonLazySafe;

    public static synchronized Singleton getSingletonLazySafe() {
        if (singletonLazySafe == null) {
            singletonLazySafe = new Singleton();
        }
        return singletonLazySafe;
    }

    /**
     * 饿汉模式
     * 没有加锁，执行效率会提高 类加载时就初始化，浪费内存
     * 是否lazy初始化：否
     * 是否线程安全：是
     */
    private static Singleton singletonInitialized = new Singleton();

    public static Singleton getSingletonInitialized() {
        return singletonInitialized;
    }

    /**
     * 双检锁，DCL, double-checked locking
     * 采用双锁机制，安全且在多线程情况下能保持高性能
     * 是否lazy初始化：是
     * 是否线程安全：是
     */
    private volatile static Singleton singletonVolatileSafe;

    public static Singleton getSingletonVolatileSafe() {
        if (singletonVolatileSafe == null) {
            synchronized (Singleton.class) {
                if (singletonVolatileSafe == null) {
                    singletonVolatileSafe = new Singleton();
                }
            }
        }
        return singletonVolatileSafe;
    }

    /**
     * 登记式，静态内部类
     * SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类
     * 是否lazy初始化：是
     * 是否线程安全：是
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args) {

    }


}
