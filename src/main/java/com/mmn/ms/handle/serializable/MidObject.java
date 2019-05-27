package com.mmn.ms.handle.serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Mmn on 2019/5/24.
 * To be a happy coder!
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MidObject {
    private Integer midId;

    private String midName;

    private List<SmallObject> smallObjects;

    @Override
    public String toString() {
        return "MidObject{" +
                "midId=" + midId +
                ", midName='" + midName + '\'' +
                ", smallObjects=" + smallObjects.toString() +
                '}';
    }
}
