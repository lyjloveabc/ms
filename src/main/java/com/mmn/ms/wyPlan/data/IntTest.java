package com.mmn.ms.wyPlan.data;

import lombok.extern.java.Log;

/**
 * Created by Mmn on 2019/1/24.
 * To be a happy coder!
 */
@Log
public class IntTest {
    public static void main(String[] args) {
        /*int num = 100000000;

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            Integer.parseInt("1");
        }

        long t2 = System.currentTimeMillis();

        for (int i = 0; i < num; i++) {
            Integer.valueOf("1");
        }

        long t3 = System.currentTimeMillis();

        log.info("1: " + (t2 - t1));
        log.info("2: " + (t3 - t2));*/

        for (int num = 1; num <= 100000000; num = num * 10) {
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                Integer.parseInt("1");
            }
            long t2 = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                Integer.parseInt("1000");
            }
            long t3 = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                Integer.valueOf("1");
            }
            long t4 = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                Integer.valueOf("1000");
            }
            long t5 = System.currentTimeMillis();

            System.out.println(
                    "parseInt(\"1\")耗时: " + (t2 - t1)
                            + "。parseInt(\"1000\")耗时: " + (t3 - t2)
                            + "。valueOf(\"1\")耗时: " + (t4 - t3)
                            + "。valueOf(\"1000\")耗时: " + (t5 - t4)
                            + "。次数: " + num
            );
        }
    }
}

