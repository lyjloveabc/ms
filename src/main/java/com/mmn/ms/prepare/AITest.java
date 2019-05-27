package com.mmn.ms.prepare;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Mmn on 2019/1/20.
 * To be a happy coder!
 */
public class AITest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();

        System.out.println(atomicInteger.getAndIncrement());
    }
}
