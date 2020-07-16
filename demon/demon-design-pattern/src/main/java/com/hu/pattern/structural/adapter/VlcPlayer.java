package com.hu.pattern.structural.adapter;

/**
 * @author : hudelin
 * @className :VlcPlayer
 * @description :video播放器
 * @date: 2020-07-16 15:23
 */
public class VlcPlayer implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("播放video，文件名：" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
