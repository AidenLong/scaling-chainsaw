package com.me.ready.code;

import java.lang.reflect.Field;

/**
 * @Autor syl
 * @Date 2019/1/31 9:58
 **/
public class Swap {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;   // Integer a = Integer.valueO(1);
        swap(a, b);
        System.out.println(a + "====" + b);
    }

    public static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
        // Integer 的value属性是final的，所以传过来的是一个副本，因此改变原数据，只能通过反射实现
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);  // obj.override = flag;
        Integer tmp = new Integer(i1.intValue());
//        int tmp = i1.intValue();
        field.set(i1, i2.intValue());//i1->Integer.valueOf(i2.intValue())
        field.set(i2, tmp); // i2->i1->Integer.valueOf(tmp) 拿出缓存的值
        /**
         *  public static Integer valueOf(int i) {
         *         if (i >= IntegerCache.low && i <= IntegerCache.high)
         *             return IntegerCache.cache[i + (-IntegerCache.low)];
         *         return new Integer(i);
         *     }
         */
    }
}
