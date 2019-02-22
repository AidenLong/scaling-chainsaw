package com.me.proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @Autor syl
 * @Date 2019/1/31 10:33
 **/
public class ProxyDemo {

    public static void main(String[] args) {
        /*Payment payment = new ThirdChannelPayment();
        System.out.println(payment.doPay("mic"));

        ThirdChannelProxy proxy = new ThirdChannelProxy();
        proxy.doPay("Mic");

        DynamicProxy dynamicProxy = new DynamicProxy();
        Payment payment = new ThirdChannelPayment();
        Payment p1 = (Payment) dynamicProxy.bind(payment);
        System.out.println(p1.doPay("mic"));

        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", ThirdChannelPayment.class.getInterfaces());
        String path = "PaymentProxy.class";
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("end");
        } catch (Exception e) {

        }*/

        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "cglib");

        CglibProxy cglibProxy = new CglibProxy();
        ThirdChannelPayment payment = new ThirdChannelPayment();
        ThirdChannelPayment p1 = (ThirdChannelPayment) cglibProxy.getInstance(payment);
        System.out.println(p1.doPay("mic"));
    }
}
