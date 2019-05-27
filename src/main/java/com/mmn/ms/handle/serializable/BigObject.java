package com.mmn.ms.handle.serializable;

import com.google.common.collect.Lists;
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
public class BigObject {
    private Integer id;

    private String name;

    private List<MidObject> midObjectList;

    @Override
    public String toString() {
        return "BigObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", midObjectList=" + midObjectList.toString() +
                '}';
    }

    public static final BigObject BIG_OBJECT = BigObject.builder()
            .id(1)
            .midObjectList(
                    Lists.newArrayList(
                            MidObject.builder()
                                    .midId(11)
                                    .midName("中对象11")
                                    .smallObjects(
                                            Lists.newArrayList(
                                                    SmallObject.builder()
                                                            .A(111)
                                                            .B(112)
                                                            .C("C111")
                                                            .D("D112")
                                                            .build(),
                                                    SmallObject.builder()
                                                            .A(113)
                                                            .B(114)
                                                            .C("C113")
                                                            .D("D114")
                                                            .build(),
                                                    SmallObject.builder()
                                                            .A(115)
                                                            .B(null)
                                                            .C("C115")
                                                            .D(null)
                                                            .build()
                                            )
                                    )
                                    .build(),
                            MidObject.builder()
                                    .midId(12)
                                    .midName("中对象12")
                                    .smallObjects(
                                            Lists.newArrayList(
                                                    SmallObject.builder()
                                                            .A(121)
                                                            .B(122)
                                                            .C("C121")
                                                            .D("D122")
                                                            .build()
                                            )
                                    )
                                    .build()
                    )
            )
            .name("大对象1")
            .build();
}
