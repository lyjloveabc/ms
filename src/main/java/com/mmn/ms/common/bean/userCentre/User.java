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
public class User {
    public User(String name){
        this.name = name;
    }

    public enum SexType {
        F, M
    }

    private Integer id;

    private String name;

    private Integer age;

    private SexType sex;//F:female,M:male

    private List<Role> roles;

    //constant
    public static final String CONSTANT = "OK";
    public  final String CONSTANT_2 = "NO";

    //static code block
    static {
        System.out.println("init……");
        System.out.println("User's static code block");
    }
}
