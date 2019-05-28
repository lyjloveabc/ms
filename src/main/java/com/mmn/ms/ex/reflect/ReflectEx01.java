package com.mmn.ms.ex.reflect;

import com.google.common.collect.Lists;
import com.mmn.ms.common.bean.userCentre.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Mmn on 2019/5/27.
 * To be a happy coder!
 */
public class ReflectEx01 {
    public static void main(String[] args) {
        User user = User.builder()
                .age(18)
                .id(1)
                .name("刘宣")
                .roles(Lists.newArrayList())
                .sex(User.SexType.F)
                .build();

        Class userClass = user.getClass();

        Field[] fields = userClass.getDeclaredFields();
        Method[] methods = userClass.getDeclaredMethods();
        Constructor[] constructors = userClass.getConstructors();

        for (Field field : fields) {
            System.out.println(field.getName() + ", " + field.getType());
        }

        for (Method method : methods) {
            System.out.println(method.getName());
        }

        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName() + ", " + constructor.getModifiers());
        }
    }
}
