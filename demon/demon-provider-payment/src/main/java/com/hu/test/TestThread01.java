package com.hu.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class TestThread01 {

    static char[] a1 = "123456".toCharArray();
    static char[] a2 = "ABCDEF".toCharArray();

    // 使用LockSupport.park()
//    static Thread t1 = null;
//    static Thread t2 = null;
//    public static void main(String[] args) {
//        t1 = new Thread(() -> {
//            for (char c : a1) {
//                System.out.println(c);
//                LockSupport.unpark(t2);
//                LockSupport.park();
//            }
//        }, "t1");
//        t2 = new Thread(() -> {
//            for (char c : a2) {
//                LockSupport.park();
//                System.out.println(c);
//                LockSupport.unpark(t1);
//            }
//        }, "t2");
//        t1.start();
//        t2.start();
//    }

    // 使用枚举
//    enum ReadyToRun {T1, T2}
//    static volatile ReadyToRun r = ReadyToRun.T1;
//    public static void main(String[] args) {
//        new Thread(() -> {
//            for (char c : a1) {
//                while (r != ReadyToRun.T1) {
//
//                }
//                System.out.println(c);
//                r = ReadyToRun.T2;
//            }
//        }, "t1").start();
//        new Thread(() -> {
//            for (char c : a2) {
//                while (r != ReadyToRun.T2) {
//
//                }
//                System.out.println(c);
//                r = ReadyToRun.T1;
//            }
//        }, "t2").start();
//    }

    // 使用AtomicInteger
//    static AtomicInteger threadNo = new AtomicInteger(1);
//    public static void main(String[] args) {
//        new Thread(() -> {
//            for (char c : a1) {
//                while (threadNo.get() != 1) {
//
//                }
//                System.out.println(c);
//                threadNo.set(2);
//            }
//        }, "t1").start();
//        new Thread(() -> {
//            for (char c : a2) {
//                while (threadNo.get() != 2) {
//
//                }
//                System.out.println(c);
//                threadNo.set(1);
//            }
//        }, "t2").start();
//    }

    // 使用阻塞队列BlockingQueue
//    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
//    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);
//    public static void main(String[] args) {
//        new Thread(()->{
//            for (char c : a1) {
//                System.out.println(c);
//                try {
//                    q1.put("ok");
//                    q2.take();
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        },"t1").start();
//        new Thread(()->{
//            for (char c : a2) {
//                try {
//                    q1.take();
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//                System.out.println(c);
//                try {
//                    q2.put("ok");
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//
//            }
//        },"t2").start();
//    }

    // 使用Object,t2Started/latch觉得优先
//    private static volatile boolean t2Started = false;
//    private static CountDownLatch latch = new CountDownLatch(1);
//    public static void main(String[] args) {
//        final Object o =new Object();
//        new Thread(()->{
//            try {
//                latch.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            synchronized (o){
//                while(t2Started){
//                    try {
//                        o.wait();
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//                for (char c : a1) {
//                    System.out.println(c);
//                    try {
//                        o.notify();
//                        o.wait();
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//                o.notify();
//            }
//        },"t1").start();
//        new Thread(()->{
//            synchronized (o){
//                for (char c : a2) {
//                    System.out.println(c);
//                    latch.countDown();
////                    t2Started=true;
//                    try {
//                        o.notify();
//                        o.wait();
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//                o.notify();
//            }
//        },"t1").start();
//    }

    //使用Lock

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();
        new Thread(()->{
            try {
                lock.lock();
                for (char c : a1) {
                    System.out.println(c);
                    condition2.signal();
                    condition1.await();
                }
                condition2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
        new Thread(()->{
            try {
                lock.lock();
                for (char c : a2) {
                    System.out.println(c);
                    condition1.signal();
                    condition2.await();
                }
                condition1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"t1").start();
    }
}
