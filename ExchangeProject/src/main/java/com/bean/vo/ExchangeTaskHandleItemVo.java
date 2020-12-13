package com.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeTaskHandleItemVo {

    List<String> taskHandleItemList;

    private String isHighFrequency;

    private String isBatch;

    private String createOrgId;

    private String createUserId;

    private String updateOrgId;

    private String updateUserId;

    private String version;
}
