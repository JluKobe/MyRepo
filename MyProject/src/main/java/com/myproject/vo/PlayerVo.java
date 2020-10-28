package com.myproject.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerVo {
    private int age;

    private String country;

    private String friend;

    private String glory;

    private String name;

    private String team;
}
