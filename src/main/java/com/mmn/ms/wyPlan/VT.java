package com.mmn.ms.wyPlan;

/**
 * Created by Mmn on 2019/1/23.
 * To be a happy coder!
 */
public class VT {
    boolean isStop = false;

    public void test() {
        Thread t1 = new Thread(() -> isStop = true);

        Thread t2 = new Thread(() -> {
            while (!isStop) {
                System.out.println(Thread.currentThread().getName());
            }
        });

        t2.start();
        t1.start();
    }

    public static void main(String args[]) throws InterruptedException {
        for (int i = 0; i < 25; i++) {
            new VT().test();
        }
    }
}