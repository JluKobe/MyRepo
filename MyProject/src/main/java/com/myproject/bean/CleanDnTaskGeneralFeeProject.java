package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnTaskGeneralFeeProject {
    private String id;
    private String feeStand;
    private String feeName;
    private String isDesc;
    private String descExplain;
    private String taskGuid;
}
