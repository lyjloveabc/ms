package com.mmn.ms.common.bean.userCentre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Mmn on 2019/5/27.
 * To be a happy coder!
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission {
    private Integer id;

    private String name;

    private String icon;

    private Integer sortedNum;
}
