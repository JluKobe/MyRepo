package com.myproject.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CleanDnTaskGeneralExtend {
    private String id;
    private String updateTime;
    private String rowGuid;
    private String taskCode;
    private String isEntryCenter;
    private String handleArea;
    private String otherDept;
    private String serviceType;
    private String resultType;
    private String resultName;
    private String isSchedule;
    private String isPayOnline;
    private String isExpress;
    private String isServiceTerminals;
    private String limitSceneExplain;
    private String taskGuid;
    private String limitExplain;
    private String extendField;
    private String cdOperation;
    private String cdBatch;
    private String taskHandleItem;
    private String dataSource;
    private String resultGuid;
    private String userTopicType;
    private String userCharacterTopicType;
    private String corpTopicType;
    private String corpCharacterTopicType;
    private String townName;
    private String townCode;
    private String villageName;
    private String villageCode;
    private String cdTime;
    private String onlineHandleDepth;
    private String isOnline;
    private String onlineHandleUrl;
    private String batchOld;
}
