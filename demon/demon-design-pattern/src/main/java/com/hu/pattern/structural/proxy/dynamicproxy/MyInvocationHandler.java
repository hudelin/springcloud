package com.hu.pattern.structural.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : hudelin
 * @className :MyInvocationHandler
 * @description : vip代理实现类
 * @date: 2020-06-17 10:37
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object object;

    public MyInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        playStart();
        Object invoke = method.invoke(object, args);
        playEnd();
        return invoke;
    }

    public void playStart() {
        System.out.println("电影开始前正在播放广告");
    }

    public void playEnd() {
        System.out.println("电影结束了，接续播放广告");
    }
}
