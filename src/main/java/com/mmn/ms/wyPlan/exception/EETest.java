package com.mmn.ms.wyPlan.exception;

import java.util.Objects;

/**
 * Created by Mmn on 2019/1/23.
 * To be a happy coder!
 */
public class EETest {
    public static void main(String[] args) {
        Thread t = new Thread(new ThTestMain(Thread.currentThread()));
        t.start();


    }
}

class ThTestMain implements Runnable {
    private Thread thread;

    public ThTestMain(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);

            if (Objects.equals(this.thread.getState(), Thread.State.TERMINATED)) {
                break;
            }
        }
    }
}
