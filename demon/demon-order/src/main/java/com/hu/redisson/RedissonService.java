package com.hu.redisson;

import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author hudelin
 * @date 2020/12/8
 */
@Service("redissonService")
public class RedissonService {

    @Autowired
    private RedissonClient redissonClient;

    private RedissonService(){

    }

    public void getRedissonClient() throws IOException {
        Config config = redissonClient.getConfig();
        System.out.println(config.toJSON());
    }

    /**`
     * 获取字符串对象
     *
     * @param objectName
     * @return
     */
    public <T> RBucket<T> getRBucket(String objectName) {
        return redissonClient.getBucket(objectName);
    }

    /**
     * 获取Map对象
     *
     * @param objectName
     * @return
     */
    public <K, V> RMap<K, V> getRMap(String objectName) {
        return redissonClient.getMap(objectName);
    }

    /**
     * 获取有序集合
     *
     * @param objectName
     * @return
     */
    public <V> RSortedSet<V> getRSortedSet(String objectName) {
        return redissonClient.getSortedSet(objectName);
    }

    /**
     * 获取集合
     *
     * @param objectName
     * @return
     */
    public <V> RSet<V> getRSet(String objectName) {
        return redissonClient.getSet(objectName);
    }

    /**
     * 获取列表
     *
     * @param objectName
     * @return
     */
    public <V> RList<V> getRList(String objectName) {
        return redissonClient.getList(objectName);
    }

    /**
     * 获取队列
     *
     * @param objectName
     * @return
     */
    public <V> RQueue<V> getRQueue(String objectName) {
        return redissonClient.getQueue(objectName);
    }

    /**
     * 获取双端队列
     *
     * @param objectName
     * @return
     */
    public <V> RDeque<V> getRDeque(String objectName) {
        return redissonClient.getDeque(objectName);
    }


    /**
     * 获取锁
     *
     * @param objectName
     * @return
     */
    public RLock getRLock(String objectName) {
        return redissonClient.getLock(objectName);
    }

    /**
     * 释放锁
     *
     * @param rLock
     * @return
     */
    public void unlock(RLock rLock) {
        if(rLock!=null){
            rLock.unlock();
        }
    }

    /**
     * 获取读取锁
     *
     * @param objectName
     * @return
     */
    public RReadWriteLock getRWLock(String objectName) {
        return redissonClient.getReadWriteLock(objectName);
    }

    /**
     * 获取原子数
     *
     * @param objectName
     * @return
     */
    public RAtomicLong getRAtomicLong(String objectName) {
        return redissonClient.getAtomicLong(objectName);
    }

    /**
     * 获取记数锁
     *
     * @param objectName
     * @return
     */
    public RCountDownLatch getRCountDownLatch(String objectName) {
        return redissonClient.getCountDownLatch(objectName);
    }

    /**
     * 获取消息的Topic
     *
     * @param objectName
     * @return
     */
    public <M> RTopic<M> getRTopic(String objectName) {
        return redissonClient.getTopic(objectName);
    }

//    /**
//     * 带超时的锁
//     * @param lockKey
//     * @param timeout 超时时间   单位：秒
//     */
//    public static RLock lock(String lockKey, int timeout) {
//        return redissLock.lock(lockKey, timeout);
//    }
//
//    /**
//     * 带超时的锁
//     * @param lockKey
//     * @param unit 时间单位
//     * @param timeout 超时时间
//     */
//    public static RLock lock(String lockKey, TimeUnit unit , int timeout) {
//        return redissLock.lock(lockKey, unit, timeout);
//    }
//
//    /**
//     * 尝试获取锁
//     * @param lockKey
//     * @param waitTime 最多等待时间
//     * @param leaseTime 上锁后自动释放锁时间
//     * @return
//     */
//    public static boolean tryLock(String lockKey, int waitTime, int leaseTime) {
//        return redissLock.tryLock(lockKey, TimeUnit.SECONDS, waitTime, leaseTime);
//    }
//
//    /**
//     * 尝试获取锁
//     * @param lockKey
//     * @param unit 时间单位
//     * @param waitTime 最多等待时间
//     * @param leaseTime 上锁后自动释放锁时间
//     * @return
//     */
//    public static boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
//        return redissLock.tryLock(lockKey, unit, waitTime, leaseTime);
//    }
}
