package com.hu.game;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * @author hudelin
 * @date 2021/1/15
 */
public class Asktao02 {

    private static int sum = 0;

    public static void main(String[] args) {

        AtomicBoolean hit = new AtomicBoolean(false);

        for (int i = 0; i < 10; i++) {
            int count = 0;
            sum = 0;
            do {
                boolean turn = turn1() && turn2() && turn3();
                hit.set(turn);
                count++;
            } while (!hit.get());
            System.out.println(count);
        }


    }

    private static boolean turn(int exist, int all) {
        int i = (int) (Math.random() * all);
        sum++;
        if (i < exist) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean turn1() {

        if (turn(3, 18)) {
            return true;
        }
        if (turn(2, 17)) {
            return true;
        }
        if (turn(1, 16)) {
            return true;
        }
        return false;
    }

    private static boolean turn2() {

        if (turn(2, 12)) {
            return true;
        }
        if (turn(1, 11)) {
            return true;
        }
        return false;
    }

    private static boolean turn3() {

        if (turn(1, 6)) {
            return true;
        }
        return false;
    }

}
