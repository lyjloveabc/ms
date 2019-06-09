package com.mmn.ms.arithmetic;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Created by Mmn on 2019/6/9.
 * To be a happy coder!
 */
public class Sf {
    public static void main(String[] args) {
        int[] pool = new int[]{3, 5, 6, 8, 12, 13, 4, 6, 7, 21, 5, 6, 0, 10, 11};

        int target = 34;

        int[] result = calcV2(pool, target);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] calc(int[] pool, int target) {
        if (pool == null || pool.length == 0)
            return new int[]{-1, -1};

        for (int i = 0; i < pool.length; i++) {
            for (int j = i; j < pool.length; j++) {
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
            if (pool[i] * 2 == target) {
                return new int[]{i, i};
            }

            int temp = target - pool[i];

            if (map.get(pool[i]) == null) {
                map.put(temp, i);
            } else {
                return new int[]{map.get(pool[i]), i};
            }
        }

        return new int[]{-1, -1};
    }
}
