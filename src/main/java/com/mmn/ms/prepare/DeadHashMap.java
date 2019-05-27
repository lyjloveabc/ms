package com.mmn.ms.prepare;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Mmn on 2019/1/19.
 * To be a happy coder!
 */
public class DeadHashMap {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<>(2);

        Thread t = new Thread(
                () -> {
                    for (int i = 0; i < 10000; i++) {
                        new Thread(
                                () -> map.put(UUID.randomUUID().toString(), ""), "ftf" + i
                        ).start();
                    }
                }, "ftf");

        t.start();

        t.join();
    }
}
