package com.mmn.ms.common.bean.userCentre;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Mmn on 2019/5/27.
 * To be a happy coder!
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Integer id;

    private String name;

    private List<Permission> permissions;
}
