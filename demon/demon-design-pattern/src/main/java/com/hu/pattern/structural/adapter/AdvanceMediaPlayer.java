package com.hu.pattern.structural.adapter;

/**
 * @author : hudelin
 * @className :AdvanceMediaPlayer
 * @description : 当前媒体播放器
 * @date: 2020-07-16 15:18
 */
public interface AdvanceMediaPlayer {

    /**
     * 播放video
     *
     * @param fileName
     */
    void playVlc(String fileName);

    /**
     * 播放mp4
     *
     * @param fileName
     */
    void playMp4(String fileName);
}
