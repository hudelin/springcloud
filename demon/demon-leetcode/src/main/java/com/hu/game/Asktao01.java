package com.hu.game;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hudelin
 * @date 2021/1/15
 */
public class Asktao01 {

    private static Map<Integer, Integer> map = new HashMap<>() {{
        put(6, 2400);
        put(7, 50);
        put(8, 50);
        put(9, 50);
        put(10, 50);
        put(11, 50);
        put(12, 50);
        put(13, 50);
        put(14, 60);
        put(15, 80);
        put(16, 100);
        put(17, 150);
        put(18, 200);
        put(19, 300);
        put(20, 400);
        put(21, 500);
        put(22, 600);
        put(23, 800);
        put(24, 1000);
    }};

    public static void main(String[] args) {

        Arrays.stream(new int[1]).forEach(i -> {
            AtomicInteger sum = new AtomicInteger();
            Arrays.stream(new int[1]).forEach(j -> {
                int max = test1();
                System.out.println(map.get(max));
                sum.addAndGet(map.get(max));
            });
//            System.out.println(sum);
        });
    }

    private static int test1() {
        Random random = new Random();
        random.nextInt(10);
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                int m = (int) (Math.random() * arr.length);
                int n = (int) (Math.random() * arr.length);
                int t = arr[m][n];
                arr[m][n] = arr[i][i1];
                arr[i][i1] = t;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                System.out.print(arr[i][i1]);
            }
            System.out.println();
        }
        int[] hen = new int[3];
        int[] shu = new int[3];
        int[] xie = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr[i].length; i1++) {
                hen[i] += arr[i][i1];
                shu[i] += arr[i1][i];
                if (i == i1) {
                    xie[0] += arr[i][i];
                    xie[1] += arr[arr[i].length - i - 1][i];
                }
            }
        }
        int max = 0;
        for (int i : hen) {
            max = Math.max(i, max);
//            System.out.println(i);
        }
        for (int i : shu) {
            max = Math.max(i, max);
//            System.out.println(i);
        }
        for (int i : xie) {
            max = Math.max(i, max);
//            System.out.println(i);
        }
        return max;
    }
}
