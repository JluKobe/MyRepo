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
@TableName(value = "igt_task_basic")
public class IgtTaskBasic implements Serializable {
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

    private String catalogCode;

    private String catalogName;

    private String deptCode;

    private String deptName;

    private String deptType;

    private String handleType;

    private String isBatch;

    private String isEntryCenter;

    private String isExpress;

    private String isHighFrequency;

    private String isOnline;

    private String isPayOnline;

    private String isSchedule;

    private String isServiceTerminals;

    private String isWindow;

    private String linkWay;

    private String localCatalogCode;

    private String localTaskCode;

    private String orgCode;

    private String powerSource;

    private String productSourceType;

    private String productType;

    private String projectType;

    private String promiseDay;

    private String resultName;

    private String resultType;

    private String resultSample;

    private String serverType;

    private String taskArea;

    private String taskCode;

    private String taskGuid;

    private String taskHandleItem;

    private String taskName;

    private String taskState;

    private String taskStatus;

    private String taskType;

    private String taskVersion;

    private String transactAddr;

    private String transactTime;

    private String useLevel;

    private String acceptCenterCode;
}
