package com.mmn.ms.prepare;

/**
 * Created by Mmn on 2019/3/25.
 * To be a happy coder!
 */
public class Tj {
    public static void main(String[] args) {
        String x = "\uD83D\uDE0A昵称哈哈\uD83D\uDE0A";

        System.out.println(x.length());
        System.out.println(x.charAt(0));
        System.out.println(x.codePointAt(0));
        System.out.println(x.codePointCount(0, x.length()));
        System.out.println(x.indexOf(x.codePointAt(0)));

        System.out.println(x.offsetByCodePoints(0, 1));

        System.out.println(x.substring(0, x.offsetByCodePoints(0, 1)));

        int hhh = x.codePointCount(0, x.length());

        System.out.println(
                x.substring(
                        x.offsetByCodePoints(0, hhh-1)
                )
        );
    }

    /*public static void method(int syStep) {
        if (syStep >= 1) {
            method(syStep - 1);
        } else {
            return;
        }
    }*/
}
