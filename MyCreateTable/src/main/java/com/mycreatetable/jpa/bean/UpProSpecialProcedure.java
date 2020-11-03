package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 政务服务事项办件信息 特别程序信息
 */

@Entity
@Data
@Table(name = "up_pro_special_procedure")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProSpecialProcedure {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '雪花算法生成的ID'", nullable = false)
    private Long id;

    @Column(name = "version", columnDefinition = "int(10) comment '版本号' default 1", nullable = false)
    private String version;

    @Column(name = "create_time", columnDefinition = "datetime comment '创建时间'", nullable = false)
    private String createTime;

    @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
    private String createUserId;

    @Column(name = "create_org_id", columnDefinition = "bigint(20) comment '创建机构ID'", nullable = false)
    private String createOrgId;

    @Column(name = "tenant_id", columnDefinition = "bigint(20) comment '租户ID'", nullable = false)
    private String tenantId;

    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'", nullable = false)
    private String updateTime;

    @Column(name = "update_user_id", columnDefinition = "bigint(20) comment '更新人ID'", nullable = false)
    private String updateUserId;

    @Column(name = "update_org_id", columnDefinition = "bigint(20) comment '更新机构ID'", nullable = false)
    private String updateOrgId;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "special_type", columnDefinition = "varchar(2) comment '特别程序种类'", nullable = false)
    private String specialType;

    @Column(name = "special_name", columnDefinition = "varchar(1000) comment '特别程序种类名称'", nullable = false)
    private String specialName;

    @Column(name = "special_time", columnDefinition = "datetime comment '特别程序开始时间'", nullable = false)
    private String specialTime;

    @Column(name = "special_reason", columnDefinition = "varchar(2000) comment '特别程序启动理由或依据'", nullable = false)
    private String specialReason;

    @Column(name = "applyer_user_name", columnDefinition = "varchar(100) comment '申请人'")
    private String applyerUserName;

    @Column(name = "end_time", columnDefinition = "datetime comment '特别程序结束时间'", nullable = false)
    private String endTime;

    @Column(name = "result", columnDefinition = "varchar(2000) comment '特别程序结果'")
    private String result;

    @Column(name = "special_explain", columnDefinition = "varchar(2000) comment '特别程序办理意见'")
    private String specialExplain;

    @Column(name = "handle_user", columnDefinition = "varchar(100) comment '办理人'")
    private String handleUser;

    @Column(name = "remark", columnDefinition = "varchar(256) comment '备注'")
    private String remark;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
