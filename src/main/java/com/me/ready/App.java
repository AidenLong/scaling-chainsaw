package com.me.ready;

/**
 * @Autor syl
 * @Date 2019/2/22 16:19
 **/
public class App {

    private static App d = new App();
    private SubClass t = new SubClass();

    static{
        System.out.println("App static");//6
    }

    public App(){
        System.out.println("构建App");//5
    }

    public static void main(String[] args) {
        System.out.println("App main");//7
    }
}
