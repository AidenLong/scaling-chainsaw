package com.me.ready.clone;

import java.io.IOException;

public class ClassDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Email email = new Email("111");
        User user = new User("mic");
        user.setEmail(email);
        System.out.println(user);

        User user1 = user.deptClone();
        user1.setName("jack");
        user1.getEmail().setContent("222");
        System.out.println(user1);
    }
}
