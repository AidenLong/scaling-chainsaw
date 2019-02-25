package com.me.ready.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @Autor syl
 * @Date 2019/2/25 14:41
 **/
public class FileSystemXmlApplicationContextDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("applicationContext.xml");
        ApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("applicationContext.xml");
        ((ClassPathXmlApplicationContext) applicationContext1).start();
    }
}
