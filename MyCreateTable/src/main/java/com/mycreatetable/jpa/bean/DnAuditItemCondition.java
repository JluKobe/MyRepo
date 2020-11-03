package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dn_audit_item_condition")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnAuditItemCondition {

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

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "condition_name", columnDefinition = "varchar(50) comment '情形名称'", nullable = false)
    private String conditionName;

    @Column(name = "condition_desc", columnDefinition = "varchar(500) comment '情形描述' default null")
    private String conditionDesc;

    @Column(name = "bs", columnDefinition = "varchar(2) comment '区分标识'", nullable = false)
    private String bs;

    @Column(name = "order_num", columnDefinition = "int(11) comment '情形排序'", nullable = false)
    private String orderNum;

    @Column(name = "area_code", columnDefinition = "varchar(20) comment '区划'", nullable = false)
    private String areaCode;
}
