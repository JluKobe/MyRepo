package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnTaskAuditItemCondition {
    private String id;
    private String rowGuid;
    private String taskGuid;
    private String conditionName;
    private String conditionDesc;
}
