package com.mmn.ms.wyPlan.c;

import java.util.HashSet;

/**
 * Created by Mmn on 2019/1/24.
 * To be a happy coder!
 */
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("1");
        hashSet.add("2");
        hashSet.add("3");
        hashSet.add("4");

        for (String x : hashSet) {
            System.out.println(x);
        }
    }
}
