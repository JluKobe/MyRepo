package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 区域内实施 主体信息
 */

@Entity
@Data
@Table(name = "up_zone_organization")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpZoneOrganization {

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

    @Column(name = "org_name", columnDefinition = "varchar(100) comment '部门名称'", nullable = false)
    private String orgName;

    @Column(name = "org_short_name", columnDefinition = "varchar(50) comment '部门简称'", nullable = false)
    private String orgShortName;

    @Column(name = "org_code", columnDefinition = "varchar(9) comment '组织机构代码'")
    private String orgCode;

    @Column(name = "credit_code", columnDefinition = "varchar(18) comment '统一社会信用代码'", nullable = false)
    private String creditCode;

    @Column(name = "exist_task", columnDefinition = "varchar(2) comment '部门是否存在并且行使政务服务事项'", nullable = false)
    private String existTask;

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
