package com.mmn.ms.ali;

import java.math.BigDecimal;

/**
 * Created by Mmn on 2019/1/17.
 * To be a happy coder!
 */
public class Discount {
    //题目2：实现一个特别的金额处理方法，返回最接近的形如*.49,*.99的人民币数值。
    //常用于超市打折场景。如输入 12.1，输出 11.99；输入12.311，输出12.49。输入12.74，输出12.99。

    public static void main(String[] args) {
        //System.out.println(discount(null));
        System.out.println(discount(new BigDecimal(String.valueOf(12.11))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.311))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.74))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.25))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.24))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.26))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.57))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.99))));
        System.out.println(discount(new BigDecimal(String.valueOf(12.45))));
    }

    private static BigDecimal discount(BigDecimal original) {
        if (original == null) {
            throw new NullPointerException();
        }

        if (BigDecimal.ZERO.compareTo(original) > 0) {
            throw new RuntimeException("must > 0");
        }

        //整数部分
        BigDecimal intPart = new BigDecimal(original.intValue());
        //小数部分，有可能为0
        BigDecimal diff = original.subtract(intPart);

        BigDecimal one = new BigDecimal(1);
        BigDecimal top = new BigDecimal(String.valueOf(0.99));
        BigDecimal mid = new BigDecimal(String.valueOf(0.49));

        BigDecimal result;

        if (diff.compareTo(new BigDecimal(String.valueOf(0.25))) < 0) {
            result = intPart.subtract(one).add(top);
        } else if (diff.compareTo(new BigDecimal(String.valueOf(0.25))) >= 0 && diff.compareTo(new BigDecimal(String.valueOf(0.74))) < 0) {
            result = intPart.add(mid);
        } else {
            result = intPart.add(top);
        }

        return result;
    }
}
