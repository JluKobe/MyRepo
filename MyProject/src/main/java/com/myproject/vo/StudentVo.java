package com.myproject.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentVo {
    private Long id;

    private int age;

    private String name;
}
