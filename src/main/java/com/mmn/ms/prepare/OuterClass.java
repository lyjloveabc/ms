package com.mmn.ms.prepare;

/**
 * Created by Mmn on 2019/1/22.
 * To be a happy coder!
 */
public class OuterClass {
    public static long OUTER_DATE = System.currentTimeMillis();

    public long INIT_TIME;

    public OuterClass() {
        timeElapsed();
        INIT_TIME = System.currentTimeMillis();
    }

    class InnerClass {
        public long INNER_DATE;

        public InnerClass() {
            timeElapsed();
            INNER_DATE = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {
        long t = System.currentTimeMillis();

        OuterClass outer = new OuterClass();
        System.out.println("111：" + (outer.OUTER_DATE - t));
        System.out.println("init outer：" + (outer.INIT_TIME - t));
        System.out.println("外部类静态变量加载时间：" + (outer.OUTER_DATE - t));
        System.out.println("非静态内部类加载时间" + (outer.new InnerClass().INNER_DATE - t));
    }

    //单纯的为了耗时，来扩大时间差异
    private void timeElapsed() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}