package com.mmn.ms.prepare;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Mmn on 2019/1/21.
 * To be a happy coder!
 */
public class RtRWLockTest {
    public static void main(String[] args) {
        ReadWriteLock rtLock = new ReentrantReadWriteLock();

        rtLock.readLock().lock();

        System.out.println("get readLock.");

        rtLock.writeLock().lock();

        System.out.println("blocking");
    }
}
