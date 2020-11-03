package com.mycreatetable.jpa.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UpTaskDirectoryVo {
    private String id;

    private String version;

    private String createTime;

    private String createUserId;

    private String createOrgId;

    private String tenantId;

    private String updateTime;

    private String updateUserId;

    private String updateOrgId;

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
