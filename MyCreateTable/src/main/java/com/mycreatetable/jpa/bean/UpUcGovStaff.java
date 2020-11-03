package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户信息数据 政务人员基础信息
 */

@Entity
@Data
@Table(name = "up_uc_gov_staff")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcGovStaff {
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

    @Column(name = "cert_key", columnDefinition = "varchar(128) comment '行政人员唯一标识'", nullable = false)
    private String certKey;

    @Column(name = "login_no", columnDefinition = "varchar(64) comment '登录账号'")
    private String loginNo;

    @Column(name = "staff_code", columnDefinition = "varchar(64) comment '人员编号'", nullable = false)
    private String staffCode;

    @Column(name = "staff_name", columnDefinition = "varchar(64) comment '人员名称'")
    private String staffName;

    @Column(name = "staff_phone", columnDefinition = "varchar(64) comment '人员联系电话'")
    private String staffPhone;

    @Column(name = "staff_duty", columnDefinition = "varchar(64) comment '人员岗位'")
    private String staffDuty;

    @Column(name = "staff_lvl", columnDefinition = "varchar(64) comment '人员级别'")
    private String staffLvl;

    @Column(name = "cert_type", columnDefinition = "varchar(6) comment '证件类型'")
    private String certType;

    @Column(name = "cert_no", columnDefinition = "varchar(64) comment '证件号码'")
    private String certNo;

    @Column(name = "org_id", columnDefinition = "varchar(64) comment '所在组织'", nullable = false)
    private String orgId;

    @Column(name = "region_id", columnDefinition = "varchar(64) comment '所在区域'", nullable = false)
    private String regionId;

    @Column(name = "is_real", columnDefinition = "varchar(6) comment '实名状态'", nullable = false)
    private String isReal;

    @Column(name = "real_date", columnDefinition = "varchar(20) comment '实名日期'")
    private String realDate;

    @Column(name = "real_lvl", columnDefinition = "varchar(64) comment '实名等级'", nullable = false)
    private String realLvl;

    @Column(name = "reg_date", columnDefinition = "varchar(20) comment '注册日期'")
    private String regDate;

    @Column(name = "staff_status", columnDefinition = "varchar(6) comment '人员状态'", nullable = false)
    private String staffStatus;

    @Column(name = "staff_creater", columnDefinition = "varchar(64) comment '创建用户'")
    private String staffCreater;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
