package com.mmn.ms.prepare;

/**
 * Created by Mmn on 2019/1/21.
 * To be a happy coder!
 */
public class UnReLock {
    private boolean isLocked = false;

    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public void unlock() {
        isLocked = false;
        notify();
    }

    public static void main(String[] args) {
        UnReLockTest unReLockTest = new UnReLockTest();

        unReLockTest.print();

        //new Thread(() -> new UnReLockTest().print()).start();
    }
}

class UnReLockTest {
    private UnReLock unReLock = new UnReLock();

    public void print() {
        try {
            unReLock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("p");

        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        add();

        unReLock.unlock();
    }

    public void add() {
        try {
            unReLock.lock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("+");

        unReLock.unlock();
    }
}