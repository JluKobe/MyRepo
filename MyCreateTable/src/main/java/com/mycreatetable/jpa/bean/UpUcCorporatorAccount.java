package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 用户信息数据 法人账号信息
 */

@Entity
@Data
@Table(name = "up_uc_corporator_account")
@org.hibernate.annotations.Table(appliesTo = "up_uc_corporator_account", comment = "用户信息数据 法人账号信息")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcCorporatorAccount {

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

    @Column(name = "certificate_sno", columnDefinition = "varchar(64) comment '相关法人标识'", nullable = false)
    private String certificateSno;

    @Column(name = "acct_type", columnDefinition = "varchar(64) comment '账号类型'", nullable = false)
    private String acctType;

    @Column(name = "trust_acct_no", columnDefinition = "varchar(64) comment '信任标识账号'", nullable = false)
    private String trustAcctNo;

    @Column(name = "trust_acct_no_key", columnDefinition = "varchar(128) comment '信任身份标识账号散列值'", nullable = false)
    private String trustAcctNoKey;

    @Column(name = "agent_mobile", columnDefinition = "varchar(64) comment '手机号'")
    private String agentMobile;

    @Column(name = "agent_name", columnDefinition = "varchar(64) comment '姓名'")
    private String agentName;

    @Column(name = "agent_cert", columnDefinition = "varchar(64) comment '经办人证件号码'")
    private String agentCert;

    @Column(name = "agent_cert_key", columnDefinition = "varchar(64) comment '经办人证件散列值'")
    private String agentCertKey;

    @Column(name = "agent_cert_type", columnDefinition = "varchar(12) comment '经办人证件类型'")
    private String agentCertType;

    @Column(name = "agent_cert_begin_date", columnDefinition = "varchar(12) comment '证件有效期起始日期'")
    private String agentCertBeginDate;

    @Column(name = "agent_cert_end_date", columnDefinition = "varchar(12) comment '证件有效期到期日期'")
    private String agentCertEndDate;

    @Column(name = "agent_channel", columnDefinition = "varchar(6) comment '账号来源代码'", nullable = false)
    private String agentChannel;

    @Column(name = "agent_eff_date", columnDefinition = "varchar(8) comment '有效起始日期'")
    private String agentEffDate;

    @Column(name = "agent_exp_date", columnDefinition = "varchar(8) comment '有效结束日期'")
    private String agentExpDate;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
