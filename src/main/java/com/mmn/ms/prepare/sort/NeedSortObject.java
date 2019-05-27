package com.mmn.ms.prepare.sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Mmn on 2019/2/11.
 * To be a happy coder!
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NeedSortObject {
    private int value;

    private int serialNumber;

    //构造的数据
    static final NeedSortObject[] SORT_OBJECT = new NeedSortObject[NeedSortNum.SORT_NUMBER.length];

    static {
        for (int i = 0; i < NeedSortNum.SORT_NUMBER.length; i++) {
            SORT_OBJECT[i] = NeedSortObject.builder().serialNumber(i).value(NeedSortNum.SORT_NUMBER[i]).build();
        }

        print();
    }

    static void print() {
        System.out.println("SORT_NUMBER 打印如下：");

        for (NeedSortObject temp : SORT_OBJECT) {
            System.out.println(temp);
        }

        /*int forLength = SORT_OBJECT.length - 1;

        for (int i = 0; i < forLength; i++) {
            System.out.print(SORT_OBJECT[i]);
            System.out.print(" < ");
        }

        System.out.print(SORT_OBJECT[forLength]);*/
    }
}
