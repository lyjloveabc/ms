package com.mmn.ms.handle.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Mmn on 2019/5/24.
 * To be a happy coder!
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmallObject {
    private Integer A;

    private Integer B;

    private String C;

    private String D;

    @Override
    public String toString() {
        return "SmallObject{" +
                "A=" + A +
                ", B=" + B +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                '}';
    }
}
