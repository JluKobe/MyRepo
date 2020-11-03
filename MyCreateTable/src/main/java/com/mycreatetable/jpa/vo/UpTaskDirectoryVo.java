package com.mycreatetable.jpa.vo;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpTaskDirectoryVo {
    private String id;

    private String version;

    private LocalDateTime createTime;

    private Long createUserId;

    private Long createOrgId;

    private Long tenantId;

    private LocalDateTime updateTime;

    private Long updateUserId;

    private Long updateOrgId;

    private String rowGuid;

    private String taskName;

    private String catalogCode;

    private String localCatalogCode;

    private String taskType;

    private String byLaw;

    private String useLevel;

    private String taskState;

    private Integer taskVersion;

    private LocalDateTime planEffectiveDate;

    private LocalDateTime planCancelDate;

    private String cdOperation;

    private LocalDateTime cdTime;

    private String cdBatch;

    private String dataSource;
}
