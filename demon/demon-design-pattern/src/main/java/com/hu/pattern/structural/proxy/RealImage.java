package com.hu.pattern.structural.proxy;

/**
 * @author : hudelin
 * @className :RealImage
 * @description :
 * @date: 2020-07-20 10:15
 */
public class RealImage implements Image {

    private String fileName;


    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("播放：" + fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("加载：" + fileName);
    }
}
