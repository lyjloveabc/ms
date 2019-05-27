package com.mmn.ms.draw;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Set;

/**
 * 开会抽签
 * Created by Mmn on 2019/1/18.
 * To be a happy coder!
 */
public class Random {
    /*private static final List<String> DEVELOP = Lists.newArrayList(
            "龙吉",
            "风林",
            "啸天",
            "龙环",
            "黄真",
            "方吉",
            "娇鬲",
            "苏护",
            "徐盖",
            "长乘"
    );*/

    private static final List<String> DEVELOP = Lists.newArrayList(
            "啸天",
            "苏护"
    );

    public static void main(String[] args) {
        int endIndex = DEVELOP.size() - 1;

        Set<String> yc = Sets.newHashSet();

        for (; ; ) {
            String c = DEVELOP.get(getRandom(0, endIndex));

            if (!yc.contains(c)) {
                yc.add(c);

                if (yc.size() >= 1) {
                    break;
                }
            }
        }

        System.out.println(yc);
    }

    private static int getRandom(int min, int max) {
        return (int) (min + Math.random() * (max - min + 1));
    }
}
