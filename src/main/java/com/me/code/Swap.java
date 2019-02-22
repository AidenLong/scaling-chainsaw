package com.me.code;

import java.lang.reflect.Field;

/**
 * @Autor syl
 * @Date 2019/1/31 9:58
 **/
public class Swap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        swap(a, b);
        System.out.println(a + "====" + b);
    }

    public static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
//        Integer tmp = new Integer(i1.intValue());
        int tmp = i1.intValue();
        field.setInt(i1, i2.intValue());
        field.setInt(i2, tmp);
    }
}
