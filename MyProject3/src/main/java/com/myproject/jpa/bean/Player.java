package com.myproject.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "player")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    private Long id;

    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Column(name = "country", nullable = true, length = 30)
    private String country;

    @Column(name = "team", nullable = false, length = 30)
    private String team;

    @Column(name = "age", nullable = false, length = 10)
    private int age;

    @Column(name = "glory", nullable = true, length = 300)
    private String glory;

    @Column(name = "friend", nullable = true, length = 100)
    private String friend;
}
