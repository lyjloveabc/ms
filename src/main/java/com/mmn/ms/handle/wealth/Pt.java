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
public class Pt extends Extra {
    private Integer id;

    @Override
    public String toString() {
        return "Pt{" +
                "id=" + id +
                '}';
    }
}
