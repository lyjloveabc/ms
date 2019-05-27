package com.mmn.ms.bigSc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mmn on 2019/2/18.
 * To be a happy coder!
 */
public class Statistics {
    public static void main(String[] args) {
        //charCount("asaaaaaasdssddddvdvffdfdds");
        System.out.println(charCount("a"));
    }

    private static String charCount(String str) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> tm = new HashMap<>();

        int max = 0;
        char maxChar = 0;

        for (char ch : chs) {
            Integer value = tm.get(ch) == null ? 1 : (tm.get(ch) + 1);

            tm.put(ch, value);

            if (value > max) {
                max = value;
                maxChar = ch;
            }
        }

        System.out.println(max);
        System.out.println(maxChar);

        return String.valueOf(maxChar);
    }

    private static String charCountV2(String str) {
        char[] chs = str.toCharArray();
        Map<Character, Integer> tm = new HashMap<>();

        int max = 0;
        char maxchar = 0;

        for (int x = 0; x < chs.length; x++) {
            Integer value = tm.get(chs[x]); //通过key 获取value的值get 方法这里的key是Character

            if (value == null) {
                tm.put(chs[x], 1);
            } else {
                value = value + 1;
                tm.put(chs[x], value);

                if (max < value) {
                    max = value;
                    maxchar = chs[x];
                }
            }

        }

        System.out.println(max);
        System.out.println(maxchar);

        return null;
    }
}
