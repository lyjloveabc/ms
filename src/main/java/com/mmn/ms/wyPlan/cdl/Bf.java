package com.mmn.ms.wyPlan.cdl;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Mmn on 2019/1/28.
 * To be a happy coder!
 */
public class Bf implements Runnable {
    private CountDownLatch countDownLatch;
    private CdlTest cdlTest;

    Bf(CountDownLatch countDownLatch, CdlTest cdlTest) {
        this.countDownLatch = countDownLatch;
        this.cdlTest = cdlTest;
    }

    @Override
    public void run() {
        try {
            this.countDownLatch.await();
            this.cdlTest.r--;
            System.out.println(this.cdlTest.r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
