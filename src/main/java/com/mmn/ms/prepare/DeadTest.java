package com.mmn.ms.prepare;

/**
 * Created by Mmn on 2019/1/21.
 * To be a happy coder!
 */
public class DeadTest {
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (B.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A.class) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (A.class) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                synchronized (B.class) {

                }
            }

        }).start();
    }

}

class A {

}

class B {
}