package com.mmn.ms.prepare.sort;

/**
 * Created by Mmn on 2019/2/3.
 * To be a happy coder!
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        binaryDirectInsertSort(NeedSortNum.SORT_NUMBER);

        NeedSortNum.print();
    }

    //直接插入排序
    private static void directInsertSort(int[] source) {
        int length = source.length;

        //遍历需要插入的数字
        for (int i = 1; i < length; i++) {
            //本次循环待排序的数字
            int temp = source[i];

            //从后往前比较的下标
            int j;

            //在temp前面的数字里面，比temp大的需要往后面移动
            for (j = i - 1; j >= 0 && temp < source[j]; j--) {
                source[j + 1] = source[j];
            }

            //把待排序的数字放到指定位置
            source[j + 1] = temp;
        }
    }

    //二分插入排序
    private static void binaryDirectInsertSort(int[] source) {
        int length = source.length;

        for (int i = 1; i < length; i++) {
            //本次循环待插入到有序列表的数字
            int temp = source[i];
            //二分查找的左边的开始下标
            int left = 0;
            //二分查找的右边的开始下标，10 1
            int right = i - 1;

            //找到存放的位置
            while (left <= right) {
                int mid = (left + right) / 2;//中间值

                if (temp < source[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            //left后面的全部往后移动
            if (i - left >= 0) System.arraycopy(source, left, source, left + 1, i - left);

            source[left] = temp;
        }
    }
}


