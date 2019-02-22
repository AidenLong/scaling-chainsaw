package com.me.ready;

/**
 * @Autor syl
 * @Date 2019/2/22 16:20
 **/
public class SuperClass {

    static{
        System.out.println("SuperClass static");//1
    }
    public SuperClass(){
        System.out.println("构建SuperClass");//3
    }
}
