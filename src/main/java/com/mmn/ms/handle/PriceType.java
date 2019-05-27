package com.mmn.ms.handle;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Mmn on 2019/5/5.
 * To be a happy coder!
 */
public class PriceType {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread());
        thread.setDaemon(true);
        thread.start();

        int num = 10000000;
        List<Integer> nums = Lists.newArrayList();
        for (int i = 0; i < num; i++) {
            nums.add(i);
        }
        System.out.println(nums.size());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("哈哈哈" + System.currentTimeMillis());
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
