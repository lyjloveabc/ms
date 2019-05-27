package com.mmn.ms.wyPlan;

/**
 * Created by Mmn on 2019/1/22.
 * To be a happy coder!
 */
public class DeadLock {
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (ADeadLock.class) {
                System.out.println("线程[" + Thread.currentThread().getName() + "]，进来了");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (BDeadLock.class) {
                    System.out.println("线程[" + Thread.currentThread().getName() + "]，到内部代码块了");
                }
            }
        }, "A").start();

        new Thread(() -> {
            synchronized (BDeadLock.class) {
                System.out.println("线程[" + Thread.currentThread().getName() + "]，进来了");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (ADeadLock.class) {
                    System.out.println("线程[" + Thread.currentThread().getName() + "]，到内部代码块了");
                }
            }
        }, "B").start();
    }
}

class ADeadLock {

}

class BDeadLock {

}