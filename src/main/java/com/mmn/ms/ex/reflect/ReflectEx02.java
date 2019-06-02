package com.mmn.ms.ex.reflect;

import com.mmn.ms.common.bean.userCentre.User;

import java.lang.reflect.Constructor;

/**
 * Created by Mmn on 2019/5/27.
 * To be a happy coder!
 */
public class ReflectEx02 {
    public static void main(String[] args) {
        /*try {
            Class c1 = Class.forName("com.mmn.ms.common.bean.userCentre.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Class c2 = Class.forName("com.mmn.ms.common.bean.userCentre.User");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/

        Class<User> c3 = User.class;

        try {
            Constructor<User> userConstructor = c3.getDeclaredConstructor(String.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
