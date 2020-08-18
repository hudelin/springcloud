package com.hu.util;

/**
 * @Description Twitter的分布式自增ID雪花算法snowflake
 * @Author FanChuGuang
 * @Date 2019/8/5 17:38
 * @Version 1.0
 **/
public class SnowFlakeUtil {

    // 0 - 00000000 0000000 00000000 00000000 00000000 0 - 00000000 00 - 00000000 0000
    // 1bit用于标记 long的正数符号 - 41bit 用于时间戳 - 10bit 用于机器Id - 12bit 用于序列号

    /**
     * 地址标识 工作机器ID
     */
    private static long addressId;

    /**
     * 端口标识 数据中心ID
     */
    private static long portId;

    /**
     * 起始的时间戳 2019-01-01 00:00:00
     */
    private final static long START_STAMP = 1420041600000L;

    /**
     * 工作机器ID占用的位数,2进制5位等于32，32减掉1 31个(0-31)
     */
    private final static long ADDRESS_BIT = 5;

    /**
     * 数据中心ID占用的位数,2进制5位等于32，32减掉1 31个(0-31)
     */
    private final static long PORT_BIT = 5;


    /**
     * 序列号占用的位数，,2进制12位等于4096，4096减掉1 4095个(0-4095)
     */
    private final static long SEQUENCE_BIT = 12;


    /**
     * 工作机器ID的最大值，31
     */
    private final static long MAX_ADDRESS_NUM = ~(-1L << ADDRESS_BIT);

    /**
     * 数据中心ID的最大值，31
     */
    private final static long MAX_PORT_NUM = ~(-1L << PORT_BIT);

    /**
     * 序列号的最大值，4095
     */
    private final static long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);


    /**
     * 数据中心ID向左的位移12位
     */
    private final static long PORT_LEFT = SEQUENCE_BIT;

    /**
     * 工作机器ID向左的位移17位(5+12)
     */
    private final static long ADDRESS_LEFT = PORT_BIT + SEQUENCE_BIT;

    /**
     * 时间戳向左的位移22位(5+5+12)
     */
    private final static long TIMESTAMP_LEFT = ADDRESS_BIT + PORT_BIT + SEQUENCE_BIT;


    /**
     * 序列号
     */
    private long sequence = 0L;

    /**
     * 上一次时间戳
     */
    private long lastStamp = -1L;

    /**
     * 构造函数
     *
     * @param addressId
     * @param portId
     */
    public SnowFlakeUtil(long addressId, long portId) {
        if (addressId > MAX_ADDRESS_NUM || addressId < 0) {
            throw new IllegalArgumentException("machineId can't be greater than MAX_MACHINE_NUM or less than 0");
        }
        if (portId > MAX_PORT_NUM || portId < 0) {
            throw new IllegalArgumentException("dataCenterId can't be greater than MAX_DATA_CENTER_NUM or less than 0");
        }
        SnowFlakeUtil.addressId = addressId;
        SnowFlakeUtil.portId = portId;
    }

    /**
     * 产生下一个ID
     *
     * @return
     */
    public synchronized long nextId() {
        long currStamp = getNewStamp();

        // 如果当前时间小于上次ID生成的时间戳，说明系统时间回退过这个时候，应当抛出异常
        if (currStamp < lastStamp) {
            throw new RuntimeException("Clock moved backwards.  Refusing to generate id");
        }

        // 如果是同一时间戳生成的，则进行毫秒内序列
        if (currStamp == lastStamp) {
            //相同毫秒内，序列号自增
            sequence = (sequence + 1) & MAX_SEQUENCE;
            //同一毫秒的序列数已经达到最大，重新获得新的时间戳
            if (sequence == 0L) {
                currStamp = getNextMill();
            }
        } else {
            // 不同毫秒内，序列号置为0
            sequence = 0L;
        }
        // 重置最后的时间戳
        lastStamp = currStamp;

        // 移位并通过或运算拼到一起组成64位的ID
        // 时间戳部分
        return (currStamp - START_STAMP) << TIMESTAMP_LEFT
                // 服务器地址标识部分
                | addressId << ADDRESS_LEFT
                //端口号标识部分
                | portId << PORT_LEFT
                // 序列号部分
                | sequence;
    }

    /**
     * 循环获取 不小于等于lastStamp 的下一时间戳
     * @return
     */
    private long getNextMill() {
        long mill = getNewStamp();
        while (mill <= lastStamp) {
            mill = getNewStamp();
        }
        return mill;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    private long getNewStamp() {
        return System.currentTimeMillis();
    }

    public static void main (String[] args){
        SnowFlakeUtil snowFlakeUtil=new SnowFlakeUtil(1,1);
        for(int i=0;i<10;i++){
            long id=snowFlakeUtil.nextId();
            System.out.println(id+"\t"+String.valueOf(id).length());
            System.out.println("---");
        }
    }

}
