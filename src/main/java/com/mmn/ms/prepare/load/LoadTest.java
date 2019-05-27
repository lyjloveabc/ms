package com.mmn.ms.prepare.load;

import java.util.UUID;

/**
 * Created by Mmn on 2019/1/31.
 * To be a happy coder!
 */
public class LoadTest extends LoadParentTest {
    static {
        System.out.println("儿子静态代码块");
    }

    public static void main(String[] args) {
        System.out.println( UUID.randomUUID().toString());
    }
}
