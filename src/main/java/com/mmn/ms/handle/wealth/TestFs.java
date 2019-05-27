package com.mmn.ms.handle.wealth;

import com.google.gson.Gson;

/**
 * Created by Mmn on 2019/5/23.
 * To be a happy coder!
 */
public class TestFs {
    public static void main(String[] args) {
        Gson gson = new Gson();

        BillInfoDTO billInfoDTO = BillInfoDTO.builder()
                .extra(Pt.builder().id(1).build())
                .id(2)
                .remark("呵呵")
                .build();

        String jsonStr = gson.toJson(billInfoDTO);

        System.out.println(jsonStr);

        BillInfoDTO fromJson = gson.fromJson(jsonStr, BillInfoDTO.class);

        System.out.println(fromJson.toString());

        billInfoDTO = BillInfoDTO.builder()
                .extra(Other.builder().name("小可爱").build())
                .id(2)
                .remark("呵呵")
                .build();

        jsonStr = gson.toJson(billInfoDTO);

        System.out.println(jsonStr);

        fromJson = gson.fromJson(jsonStr, BillInfoDTO.class);

        System.out.println(fromJson.toString());
    }
}
