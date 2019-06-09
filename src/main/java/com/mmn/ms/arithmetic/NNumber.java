package com.mmn.ms.arithmetic;

/**
 * Created by Mmn on 2019/6/9.
 * To be a happy coder!
 */
public class NNumber {
    public static void main(String[] args) {
        long index = 14;

        System.out.println(calc(index));
    }

    private static int calc(long index) {
        if (index == 1 || index == 2)
            return 1;
        return calc(index - 1) * calc(index - 2) + 1;
    }
}
//1, 1, 2, 3, 7, 22, 155, 3411, 528706，1803416167