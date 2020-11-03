package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 事项办件异常 数据表
 */

@Entity
@Data
@Table(name = "dn_audit_abnormal")
@org.hibernate.annotations.Table(appliesTo = "dn_audit_abnormal", comment = "事项办件异常 数据表")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnAuditAbnormal {
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

    @Column(name = "table_name", columnDefinition = "varchar(50) comment '数据表中文名'", nullable = false)
    private String tableName;

    @Column(name = "table_sql_name", columnDefinition = "varchar(50) comment '数据表英文名'", nullable = false)
    private String tableSqlName;

    @Column(name = "table_row_guid", columnDefinition = "varchar(50) comment '数据表主键'", nullable = false)
    private String tableRowGuid;

    @Column(name = "err_type", columnDefinition = "varchar(100) comment '异常类型'", nullable = false)
    private String errType;

    @Column(name = "table_cd_time", columnDefinition = "datetime comment '上传日期'", nullable = false)
    private LocalDateTime tableCdTime;

    @Column(name = "table_update_time", columnDefinition = "datetime comment '进入汇聚区日期'", nullable = false)
    private LocalDateTime tableUpdateTime;

    @Column(name = "table_cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String tableCdBatch;

    @Column(name = "table_cd_source", columnDefinition = "varchar(10) comment '数据来源'", nullable = false)
    private String tableCdSource;

    @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
    private String remark;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;
}
