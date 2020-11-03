package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户信息数据 法人身份信息
 */

@Entity
@Data
@Table(name = "up_uc_corporator_identity")
@org.hibernate.annotations.Table(appliesTo = "up_uc_corporator_identity", comment = "用户信息数据 法人身份信息")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcCorporatorIdentity {
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

    @Column(name = "corp_name", columnDefinition = "varchar(256) comment '法人名称'")
    private String corpName;

    @Column(name = "certificate_sno", columnDefinition = "varchar(128) comment '法人机构代码'")
    private String certificateSno;

    @Column(name = "certificate_key", columnDefinition = "varchar(128) comment '法人机构代码散列值'", nullable = false)
    private String certificateKey;

    @Column(name = "corp_type", columnDefinition = "varchar(64) comment '法人类型'", nullable = false)
    private String corpType;

    @Column(name = "legal_mobile", columnDefinition = "varchar(64) comment '法人代表人手机号'")
    private String legalMobile;

    @Column(name = "legal_name", columnDefinition = "varchar(64) comment '法定代表人姓名'")
    private String legalName;

    @Column(name = "legal_cert_no", columnDefinition = "varchar(64) comment '法定代表人证件号'")
    private String legalCertNo;

    @Column(name = "legal_cert_type", columnDefinition = "varchar(12) comment '法定代表人证件类型'")
    private String legalCertType;

    @Column(name = "legal_certno_begin_date", columnDefinition = "varchar(12) comment '法定代表人证件有效期起始日期'")
    private String legalCertnoBeginDate;

    @Column(name = "legal_certno_end_date", columnDefinition = "varchar(12) comment '法定代表人证件有效期到期日期'")
    private String legalCertnoEndDate;

    @Column(name = "corp_status", columnDefinition = "varchar(6) comment '法人状态'")
    private String corpStatus;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
