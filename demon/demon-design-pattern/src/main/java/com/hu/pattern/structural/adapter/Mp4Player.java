package com.hu.pattern.structural.adapter;

/**
 * @author : hudelin
 * @className :Mp4Player
 * @description : mp4播放器
 * @date: 2020-07-16 15:24
 */
public class Mp4Player implements AdvanceMediaPlayer {

    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("播放mp4，文件名：" + fileName);
    }
}
