package com.myproject.jpa.bean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "student")
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    private Long id;

    @Column(name = "name", nullable = true, length = 100)
    private String name;

    @Column(name = "age", nullable = true, length = 20)
    private int age;

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {}
}
