package com.mmn.ms.handle.serializable;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by Mmn on 2019/5/24.
 * To be a happy coder!
 */
public class TestSer implements Serializable {
    public static void main(String[] args) {
        Gson gson = new Gson();

        BigObject bigObject = BigObject.BIG_OBJECT;

        String first = gson.toJson(bigObject);

        System.out.println(first);

        BigObject fromStr = gson.fromJson(first, BigObject.class);

        System.out.println(fromStr);
    }
}
