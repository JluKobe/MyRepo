package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 社会组织法人信息
 */

@Entity
@Data
@Table(name = "up_uc_info_association")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcInfoAssociation {

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

    @Column(name = "certificate_sno", columnDefinition = "varchar(64) comment '法人标识'", nullable = false)
    private String certificateSno;

    @Column(name = "act_area", columnDefinition = "varchar(64) comment '活动地域'")
    private String actArea;

    @Column(name = "association_content", columnDefinition = "varchar(2000) comment '业务范围'")
    private String associationContent;

    @Column(name = "reg_address", columnDefinition = "varchar(128) comment '住所'")
    private String regAddress;

    @Column(name = "industry", columnDefinition = "varchar(64) comment '所属行业'")
    private String industry;

    @Column(name = "reg_date", columnDefinition = "varchar(20) comment '登记时间'")
    private String regDate;

    @Column(name = "reg_money", columnDefinition = "varchar(12) comment '注册资金'")
    private String regMoney;

    @Column(name = "association_owner", columnDefinition = "varchar(64) comment '法定代表人'")
    private String associationOwner;

    @Column(name = "competent_org", columnDefinition = "varchar(320) comment '业务主管单位'")
    private String competentOrg;

    @Column(name = "charity_org", columnDefinition = "varchar(6) comment '是否慈善组织'")
    private String charityOrg;

    @Column(name = "social_org_type", columnDefinition = "varchar(6) comment '社会组织类型'")
    private String socialOrgType;

    @Column(name = "fund_kind", columnDefinition = "varchar(6) comment '基金会类型'")
    private String fundKind;

    @Column(name = "begin_date", columnDefinition = "varchar(20) comment '证书有效期始'")
    private String beginDate;

    @Column(name = "end_date", columnDefinition = "varchar(20) comment '证书有效期止'")
    private String endDate;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
