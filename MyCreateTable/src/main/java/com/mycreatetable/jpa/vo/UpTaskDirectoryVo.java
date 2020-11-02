package com.mycreatetable.jpa.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpTaskDirectoryVo {
    private String rowGuid;

    private String taskName;

    private String catalogCode;

    private String localCatalogCode;

    private String taskType;

    private String byLaw;

    private String useLevel;

    private String taskState;

    private String taskVersion;

    private String planEffectiveDate;

    private String planCancelDate;

    private String cdOperation;

    private String cdTime;

    private String cdBatch;

    private String dataSource;
}
