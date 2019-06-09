package com.mmn.ms.arithmetic;

import com.google.common.collect.Maps;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by Mmn on 2019/6/9.
 * To be a happy coder!
 */
public class Sf {
    public static void main(String[] args) {
        int num = 10000;

        int[] pool = new int[num];
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            pool[i] = random.nextInt(num);
        }

        int target = 300;

        long t1 = System.currentTimeMillis();
        int[] result = calc(pool, target);
        long t2 = System.currentTimeMillis();

        long t3 = System.currentTimeMillis();
        int[] result2 = calcV2(pool, target);
        long t4 = System.currentTimeMillis();

        System.out.println((t2 - t1) + ": " + result[0] + " " + result[1] + ", " + pool[result[0]] + "-" + pool[result[1]]);
        System.out.println((t4 - t3) + ": " + result2[0] + " " + result2[1] + ", " + pool[result2[0]] + "-" + pool[result2[1]]);
    }

    private static int[] calc(int[] pool, int target) {
        if (pool == null || pool.length == 0)
            return new int[]{-1, -1};

        for (int i = 0; i < pool.length; i++) {
            for (int j = i + 1; j < pool.length; j++) {
                if ((pool[i] + pool[j]) == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    private static int[] calcV2(int[] pool, int target) {
        if (pool == null || pool.length == 0)
            return new int[]{-1, -1};

        Map<Integer, Integer> map = Maps.newHashMap();

        for (int i = 0; i < pool.length; i++) {
            int temp = target - pool[i];

            if (map.get(pool[i]) == null) {
                map.put(temp, i);
            } else {
                return new int[]{map.get(pool[i]), i};
            }
        }

        return new int[]{-1, -1};
    }

    //这个使用了位运算，我不会
    public int[] twoSum(int[] nums, int target) {
        int indexArrayMax = 2047;

        int[] indexArrays = new int[indexArrayMax + 1];

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[]{indexArrays[index] - 1, i};
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }

        throw new IllegalArgumentException("No two sum value");
    }
}
