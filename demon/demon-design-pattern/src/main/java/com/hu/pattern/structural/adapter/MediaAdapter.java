package com.hu.pattern.structural.adapter;

/**
 * @author : hudelin
 * @className :MediaAdapter
 * @description : 播放器适配器
 * @date: 2020-07-16 15:26
 */
public class MediaAdapter implements MediaPlayer {

    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if ("vlc".equals(audioType)) {
            advanceMediaPlayer = new VlcPlayer();
        } else if ("mp4".equals(audioType)) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if ("vlc".equals(audioType)) {
            advanceMediaPlayer.playVlc(fileName);
        } else if ("mp4".equals(audioType)) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
