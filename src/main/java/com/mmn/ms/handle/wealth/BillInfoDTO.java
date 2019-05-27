package com.mmn.ms.handle.wealth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Mmn on 2019/5/23.
 * To be a happy coder!
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillInfoDTO {
    private Integer id;

    private String remark;

    private Extra extra;

    @Override
    public String toString() {
        return "BillInfoDTO{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", extra=" + extra.toString() +
                '}';
    }
}
