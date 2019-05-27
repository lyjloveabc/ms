package com.mmn.ms.wyPlan;

import lombok.extern.java.Log;

/**
 * Created by Mmn on 2019/1/29.
 * To be a happy coder!
 */
@Log
public class Temp {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReaderThread().start();
        number = 42;
        ready = true;
    }
}
