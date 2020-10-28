package com.myproject.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RecoverDataLogVo {
    private Long id;

    private String operateType;

    private String log;

    private Date operateTime;

    private String error;
}
