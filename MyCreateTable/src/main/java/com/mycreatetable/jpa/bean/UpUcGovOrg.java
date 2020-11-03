package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户信息数据 组织结构
 */

@Entity
@Data
@Table(name = "up_uc_gov_org")
@org.hibernate.annotations.Table(appliesTo = "up_uc_gov_org", comment = "用户信息数据 组织结构")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcGovOrg {
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

    @Column(name = "org_code", columnDefinition = "varchar(64) comment '组织机构编码'", nullable = false)
    private String orgCode;

    @Column(name = "org_name", columnDefinition = "varchar(256) comment '组织机构名称'", nullable = false)
    private String orgName;

    @Column(name = "org_cc_code", columnDefinition = "varchar(128) comment '统一社会信用代码'", nullable = false)
    private String orgCcCode;

    @Column(name = "parent_org_code", columnDefinition = "varchar(64) comment '上级机构组织编码'")
    private String parentOrgCode;

    @Column(name = "org_type", columnDefinition = "varchar(64) comment '组织机构类型'", nullable = false)
    private String orgType;

    @Column(name = "reg_address", columnDefinition = "varchar(64) comment '注册地址'")
    private String regAddress;

    @Column(name = "reg_date", columnDefinition = "varchar(8) comment '注册日期'")
    private String regDate;

    @Column(name = "oper_eff_date", columnDefinition = "varchar(20) comment '经营期限-起始'")
    private String operEffDate;

    @Column(name = "oper_exp_date", columnDefinition = "varchar(20) comment '经营期限-结束'")
    private String operExpDate;

    @Column(name = "region_code", columnDefinition = "varchar(64) comment '行政区域编码'", nullable = false)
    private String regionCode;

    @Column(name = "org_status", columnDefinition = "varchar(6) comment '组织状态'", nullable = false)
    private String orgStatus;

    @Column(name = "org_seq", columnDefinition = "int(11) comment '组织顺序'", nullable = false)
    private Integer orgSeq;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
