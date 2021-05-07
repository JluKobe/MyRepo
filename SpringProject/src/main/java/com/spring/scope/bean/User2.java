package com.spring.scope.bean;

import lombok.Data;

@Data
public class User2 {
    private String name;
    private int age;

    public User2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
