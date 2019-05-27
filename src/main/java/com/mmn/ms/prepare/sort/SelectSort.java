package com.mmn.ms.prepare.sort;

/**
 * Created by Mmn on 2019/2/11.
 * To be a happy coder!
 */
public class SelectSort {
    public static void main(String[] args) {
        sort(NeedSortObject.SORT_OBJECT);
    }

    private static void sort(NeedSortObject[] source) {
        if (source != null && source.length > 0) {

            NeedSortObject temp;
            int min;

            for (int i = 0; i < source.length - 1; i++) {
                min = i;

                for (int j = i + 1; j < source.length; j++) {
                    if (source[j].getValue() < source[min].getValue()) {
                        min = j;
                    }
                }

                if (i != min) {
                    temp = source[i];
                    source[i] = source[min];
                    source[min] = temp;
                }
            }
        }

        NeedSortObject.print();
    }
}
