package com.bean.entity.igt;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableName(value = "igt_task_extend")
public class IgtTaskExtend implements Serializable {
    private static final long serialVersionUID = -108907189034815108L;

    @Id
    private String id;

    private String createOrgId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String createTime;

    private String createUserId;

    private String updateOrgId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String updateTime;

    private String updateUserId;

    private String version;

    private String acceptCondition;

    private String anticipateDay;

    private String anticipateExplain;

    private String anticipateType;

    private String appIsSingleLogin;

    private String byLaw;

    private String bySuppose;

    private String cdBatch;

    private String entrustName;

    private String handleArea;

    private String handleFlow;

    private String isSingleLogin;

    private String limitSceneExplain;

    private String limitSceneNum;

    private String linkAddr;

    private String mobileTerminalUrl;

    private String onlineHandleDepth;

    private String onlineHandleUrl;

    private String otherDept;

    private String planCancelDate;

    private String planEffectiveDate;

    private String promiseExplain;

    private String promiseType;

    private String serviceType;

    private String specialProcedure;

    private String superviseWay;

    private String taskGuid;
}
