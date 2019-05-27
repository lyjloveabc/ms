package com.mmn.ms.wyPlan.cdl;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Mmn on 2019/1/28.
 * To be a happy coder!
 */
public class CdlTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    Integer r;

    public static void main(String[] args) throws InterruptedException {
        CdlTest cdlTest = new CdlTest();
        cdlTest.r = 100;

        for (int i = 0; i < 100; i++) {
            new Thread(new Bf(countDownLatch, cdlTest)).start();
        }

        Thread.sleep(1000L);
        countDownLatch.countDown();

        System.out.println(cdlTest.r);
    }
}