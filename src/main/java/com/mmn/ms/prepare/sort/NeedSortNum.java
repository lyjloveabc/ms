package com.mmn.ms.prepare.sort;

/**
 * Created by Mmn on 2019/2/3.
 * To be a happy coder!
 */
public class NeedSortNum {
    static final int[] SORT_NUMBER = {57, 68, 59, 52, 68, 3, 90, 100, 1, 68, 68, 10, 20, 31, 68, 59, 59, 59, 68};

    static void print() {
        System.out.println("SORT_NUMBER 打印如下：");

        int forLength = SORT_NUMBER.length - 1;

        for (int i = 0; i < forLength; i++) {
            System.out.print(SORT_NUMBER[i]);
            System.out.print(" < ");
        }

        System.out.print(SORT_NUMBER[forLength]);
    }
}
