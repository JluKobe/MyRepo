package com.myproject.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WordVo {
    private String word;

    private String meaning;

    private String sentence;
}
