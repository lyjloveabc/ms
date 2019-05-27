package com.mmn.ms.prepare;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Mmn on 2019/3/26.
 * To be a happy coder!
 */
public class Tj2 {

    public static void main(String[] args) throws ParseException {
        //这个testStr实际上就是"特殊的昵称😊"，我把表情复制上去就自动变成了橘黄色的Unicode数值
        /*String testStr = "特殊的昵称\uD83D\uDE0A";

        System.out.println("字符串的长度：" + testStr.length());

        System.out.println("所有字符串如下：");
        for (char c : testStr.toCharArray()) {
            System.out.println(c);
        }

        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID().toString().length());*/

        /*BigDecimal roundAmount = new BigDecimal("0.87");
        if (new BigDecimal("0.09").compareTo(roundAmount) < 0 || new BigDecimal("0.01").compareTo(roundAmount) > 0) {
            throw new RuntimeException("抹零金额值不正确");
        }*/
        Date d1  = DateUtils.parseDate("2019-05-03", "yyyy-MM-dd");
        Date d2  = DateUtils.parseDate("2019-05-31", "yyyy-MM-dd");
        System.out.println(differenceDays(d1, d2));
    }

    static Long differenceDays(Date start, Date end) {
        return (end.getTime() - start.getTime()) / DateUtils.MILLIS_PER_DAY + 1;
    }
}
