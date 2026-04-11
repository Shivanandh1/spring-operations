package org.example;

import java.lang.reflect.Field;

class User {
    private String name;
}

public class ReflectionExample {
    public static void main(String[] args) throws Exception {

        User user = new User();

        Field field = user.getClass().getDeclaredField("name");
        field.setAccessible(true); // access private field

        field.set(user, "Shiv Kumar");

        System.out.println(field.get(user)); // Shiv Kumar
    }
}