package com.hu.pattern.structural.adapter;

/**
 * @author : hudelin
 * @className :MediaAdapter
 * @description : 媒体播放器接口
 * @date: 2020-07-16 15:19
 */
public interface MediaPlayer {

    /**
     * 播放
     *
     * @param audioType
     * @param fileName
     */
    void play(String audioType, String fileName);

}
