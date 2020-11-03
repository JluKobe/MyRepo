package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 许可、给付、奖励、确认、裁决、其他类事项 收费项目信息
 */

@Entity
@Data
@Table(name = "dn_task_general_fee_project")
@org.hibernate.annotations.Table(appliesTo = "dn_task_general_fee_project", comment = "许可、给付、奖励、确认、裁决、其他类事项 收费项目信息")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnTaskGeneralFeeProject {
    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '雪花算法生成的ID'", nullable = false)
    private Long id;

    @Column(name = "version", columnDefinition = "int(10) comment '版本号' default 1", nullable = false)
    private Integer version;

    @Column(name = "create_time", columnDefinition = "datetime comment '创建时间'", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
    private Long createUserId;

    @Column(name = "create_org_id", columnDefinition = "bigint(20) comment '创建机构ID'", nullable = false)
    private Long createOrgId;

    @Column(name = "tenant_id", columnDefinition = "bigint(20) comment '租户ID'", nullable = false)
    private Long tenantId;

    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "update_user_id", columnDefinition = "bigint(20) comment '更新人ID'", nullable = false)
    private Long updateUserId;

    @Column(name = "update_org_id", columnDefinition = "bigint(20) comment '更新机构ID'", nullable = false)
    private Long updateOrgId;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "fee_name", columnDefinition = "varchar(200) comment '收费项目名称'", nullable = false)
    private String feeName;

    @Column(name = "fee_stand", columnDefinition = "varchar(256) comment '收费标准'", nullable = false)
    private String feeStand;

    @Column(name = "by_law", columnDefinition = "varchar(256) comment '收费依据'")
    private String byLaw;

    @Column(name = "is_desc", columnDefinition = "varchar(2) comment '是否允许减免'")
    private String isDesc;

    @Column(name = "desc_explain", columnDefinition = "varchar(256) comment '允许减免依据'")
    private String descExplain;

    @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
    private String remark;

    @Column(name = "order_num", columnDefinition = "int(11) comment '排序'", nullable = false)
    private Integer orderNum;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
