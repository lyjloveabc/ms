package com.mmn.ms.prepare.sort;

/**
 * Created by Mmn on 2019/2/11.
 * To be a happy coder!
 */
public class DirectInsertSort2 {
    public static void main(String[] args) {
        binarySort(NeedSortObject.SORT_OBJECT);
    }

    /*
    直接插入排序
     */
    private static void sort(int[] source) {
        if (source != null && source.length > 0) {
            int length = source.length;

            for (int i = 1; i < length; i++) {
                int temp = source[i];
                int j;

                for (j = i - 1; j >= 0; j--) {
                    if (temp >= source[j]) {
                        break;
                    }

                    source[j + 1] = source[j];
                }

                source[j + 1] = temp;
            }
        }

        NeedSortNum.print();
    }

    /*
    直接插入排序
     */
    private static void sort(NeedSortObject[] source) {
        if (source != null && source.length > 0) {
            int length = source.length;

            for (int i = 1; i < length; i++) {
                NeedSortObject temp = source[i];
                int j;

                for (j = i - 1; j >= 0; j--) {
                    if (temp.getValue() >= source[j].getValue()) {
                        break;
                    }

                    source[j + 1] = source[j];
                }

                source[j + 1] = temp;
            }
        }

        NeedSortObject.print();
    }

    private static void binarySort(NeedSortObject[] source) {
        if (source != null && source.length != 0) {
            int length = source.length;

            for (int i = 1; i < length; i++) {
                NeedSortObject temp = source[i];

                int mid;
                int left = 0;
                int right = i - 1;

                while (left <= right) {
                    mid = (left + right) / 2;


                    if (temp.getValue() < source[mid].getValue()) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }

                int j;
                for (j = i - 1; j >= left; j--) {
                    source[j + 1] = source[j];
                }

                source[left] = temp;
            }
        }

        NeedSortObject.print();
    }
}


