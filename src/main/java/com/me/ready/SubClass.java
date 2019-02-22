package com.me.ready;

/**
 * @Autor syl
 * @Date 2019/2/22 16:21
 **/
public class SubClass extends SuperClass {

    static{
        System.out.println("SubClass static");//2
    }
    public SubClass(){
        //super()
        System.out.println("构建SubClass");//4
    }
}
