package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnAuditMaterialCondition {
    private String id;
    private String conditionGuid;
    private String materialGuid;
}
