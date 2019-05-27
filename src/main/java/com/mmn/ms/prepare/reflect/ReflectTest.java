package com.mmn.ms.prepare.reflect;

import com.google.common.collect.Lists;
import lombok.extern.java.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.concurrent.*;

/**
 * Created by Mmn on 2019/1/29.
 * To be a happy coder!
 */
@Log
public class ReflectTest {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        ReflectObject reflectObject = new ReflectObject();

        Class cz = reflectObject.getClass();

        Field[] fields = cz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            log.info("field: " + field.getName() + ", " + field.get(reflectObject));
        }

        for (Method method : cz.getDeclaredMethods()) {
            method.setAccessible(true);
            log.info("method: " + method.getName() + ", " + method.invoke(reflectObject));
        }

        ArrayBlockingQueue<Runnable> reflectTests = new ArrayBlockingQueue<>(100);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,
                100,
                1000L,
                TimeUnit.HOURS,
                reflectTests,
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

    }
}
