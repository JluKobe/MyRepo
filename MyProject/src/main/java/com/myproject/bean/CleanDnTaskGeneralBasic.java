package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnTaskGeneralBasic {
    private String id;
    private String updateTime;
    private String rowGuid;
    private String catalogCode;
    private String taskCode;
    private String taskName;
    private String taskType;
    private String useLevel;
    private String deptType;
    private String deptName;
    private String taskState;
    private String serverType;
    private String projectType;
    private String acceptCondition;
    private String promiseType;
    private String promiseDay;
    private String deptCode;
    private String entrustName;
    private String anticipateDay;
    private String anticipateType;
    private String isFee;
    private String planCancelDate;
    private String planEffectiveDate;
    private String superviseWay;
    private String linkWay;
    private String transactTime;
    private String transactAddr;
    private String isSingleLogin;
    private String mobileTerminalUrl;
    private String cdOperation;
    private String cdBatch;
    private String byLaw;
    private String handleType;
    private String handleFlow;
    private String powerSource;
    private String taskHandleItem;
    private String localCatalogCode;
    private String localTaskCode;
    private String dataSource;
    private String feeBasis;
    private String appIsSingleLogin;
    private String linkAddr;
    private String cdTime;
    private String taskVersion;
    private String specialProcedure;
    private String limitSceneNum;
    private String anticipateExplain;
    private String promiseExplain;
    private String areaCode;
    private String changChunCode;
    private String batchOld;
}
