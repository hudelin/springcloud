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
/**
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 *
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 *
 * 何时使用：当您想控制实例数目，节省系统资源的时候。
 *
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 *
 * 关键代码：构造函数是私有的。
 *
 * 应用实例：
 *
 * 1、一个班级只有一个班主任。
 * 2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
 * 3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。
 * 优点：
 *
 * 1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。
 * 2、避免对资源的多重占用（比如写文件操作）。
 * 缺点：没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。
 *
 * 使用场景：
 *
 * 1、要求生产唯一序列号。
 * 2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
 * 3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。
 * 注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。
 */
