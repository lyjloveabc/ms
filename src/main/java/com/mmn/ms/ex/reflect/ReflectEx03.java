package com.mmn.ms.ex.reflect;

import com.mmn.ms.common.bean.userCentre.User;

import java.lang.reflect.Field;

/**
 * Created by Mmn on 2019/6/1.
 * To be a happy coder!
 */
public class ReflectEx03 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        System.out.println(User.CONSTANT);

        Class<User> userClass = User.class;

        User user = userClass.newInstance();

        Field field = userClass.getDeclaredField("CONSTANT_2");
//        field.set(user, "呵呵");

        System.out.println(user);
    }
}
