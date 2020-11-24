package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnTaskGeneralMaterial {
    private String id;
    private String taskGuid;
    private String rowGuid;
    private String materialName;
    private String pageNum;
    private String pageFormat;
    private String materialType;
    private String materialFormat;
    private String formGuid;
    private String exampleGuid;
    private String isNeed;
    private String sourceType;
    private String sourceExplain;
    private String fillExplain;
    private String byLaw;
    private String acceptStand;
}
