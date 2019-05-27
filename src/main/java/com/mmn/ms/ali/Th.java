package com.mmn.ms.ali;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Mmn on 2019/1/17.
 * To be a happy coder!
 */
public class Th {
    static CountDownLatch CDL = new CountDownLatch(3);

    private static volatile int index = 0;

    public static void main(String[] args) {
        char[] data = getAliArray(3);
        for (char row : data) {
            System.out.print(row);
        }
        System.out.println();
    }

    private static char[] getAliArray(int n) {
        if (n <= 0) {
            return new char[0];
        }


        char[] result = new char[3 * n];

        Thread t1 = new Thread(() -> {
            result[index] = 'A';
            index++;
            CDL.countDown();
        });

        Thread t2 = new Thread(() -> {
            result[index] = 'l';
            index++;
            CDL.countDown();
        });

        Thread t3 = new Thread(() -> {
            result[index] = 'i';
            index++;
            CDL.countDown();
        });

        t1.start();
        t2.start();
        t3.start();

        return result;
    }

}
