package com.hu.pattern.structural.proxy.dynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : hudelin
 * @className :CglibProxyInterceptor
 * @description : 代理类
 * @date: 2020-06-17 10:04
 */
public class CglibProxyInterceptor implements MethodInterceptor {


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        playStart();
        Object object = methodProxy.invokeSuper(o, objects);
        playEnd();
        return object;
    }

    public void playStart() {
        System.out.println("电影开始前正在播放广告");
    }

    public void playEnd() {
        System.out.println("电影结束了，接续播放广告");
    }
}
