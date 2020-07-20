package com.hu.pattern.structural.proxy.dynamicproxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author : hudelin
 * @className :CglibProxyTest
 * @description : 动态代理测试类
 * @date: 2020-06-17 10:15
 */
public class CglibProxyTest {

    public static void main(String[] args) {

        //接口
        IronManVIPMovie ironManVIPMovie = new IronManVIPMovie();
        InvocationHandler invocationHandler = new MyInvocationHandler(ironManVIPMovie);
        VIPMovie dynamicProxy = (VIPMovie) Proxy.newProxyInstance(IronManVIPMovie.class.getClassLoader(),
                IronManVIPMovie.class.getInterfaces(), invocationHandler);
        dynamicProxy.vipPlay();

        //类动态代理
//        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\Lenovo\\Desktop\\class");


        Enhancer enhancer = new Enhancer();
        //设置目标类的字节码文件
        enhancer.setSuperclass(Movie.class);
        //设置回调函数
        enhancer.setCallback(new CglibProxyInterceptor());
        Movie captainAmerica2Movie = (Movie)enhancer.create();

        //调用代理类的play方法
        captainAmerica2Movie.play();
        System.out.println("cglib动态代理《movie》："+captainAmerica2Movie.getClass());


    }

}
