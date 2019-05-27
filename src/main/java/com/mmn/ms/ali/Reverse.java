package com.mmn.ms.ali;

/**
 * Created by Mmn on 2019/1/17.
 * To be a happy coder!
 */
public class Reverse {
    //题目1：数字反转，比如：123456 转换完数字是 654321

    public static void main(String[] args) throws Exception {
        System.out.println(reverse(null));
        System.out.println(reverse(123456L));
        System.out.println(reverse(-123456L));
        System.out.println(reverse(1234567891111112222L));
        System.out.println(reverse(-1234567891111112222L));

    }

    private static Long reverse(Long number) {
        //校验方法参数
        if (number == null) {
            throw new NullPointerException();
        }

        //把Long型转成数字，可能带负号
        String digits = String.valueOf(number);

        //处理时取出负号
        if (number < 0) {
            digits = digits.substring(1);
        }

        //翻转后的数字对应的字符串
        StringBuilder result = new StringBuilder();

        //具体的反转逻辑
        char[] charArray = digits.toCharArray();
        int length = charArray.length - 1;
        for (int i = length; i >= 0; i--) {
            result.append(charArray[i]);
        }

        //带上原来的负号
        if (number < 0) {
            result.insert(0, "-");
        }

        //转成Long型并返回
        return Long.valueOf(result.toString());
    }
}
