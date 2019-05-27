package com.mmn.ms.prepare.sort;

/**
 * Created by Mmn on 2019/2/11.
 * To be a happy coder!
 */
public class BubbleSort {
    public static void main(String[] args) {
        sort(NeedSortObject.SORT_OBJECT);
    }

    private static void sort(NeedSortObject[] source) {
        if (source != null && source.length != 0) {
            NeedSortObject temp;

            for (int i = 0; i < source.length - 1; i++) {
                for (int j = 0; j < source.length - i - 1; j++) {
                    if (source[j].getValue() > source[j + 1].getValue()) {
                        temp = source[j];
                        source[j] = source[j + 1];
                        source[j + 1] = temp;
                    }
                }
            }
        }

        NeedSortObject.print();
    }
}
