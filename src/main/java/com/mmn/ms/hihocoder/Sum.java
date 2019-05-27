package com.mmn.ms.hihocoder;

import java.util.Scanner;

/**
 * Created by Mmn on 2019/1/22.
 * To be a happy coder!
 */
public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }

    public static Integer[] sum(Integer[][] original) {
        if (original == null) {
            return null;
        }

        if (original.length == 0) {
            return new Integer[]{0};
        }

        Integer[] result = new Integer[original.length];
        int index = 0;
        for (Integer[] first : original) {
            result[index] = 0;
            for (Integer value : first) {
                result[index] += value;
            }

            index++;
        }

        return result;
    }
}
