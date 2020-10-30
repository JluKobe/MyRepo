package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 法人身份信息
 */

@Entity
@Data
@Table(name = "up_uc_corporator_identity")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcCorporatorIdentity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "corp_name", columnDefinition = "varchar(128) comment '法人名称'")
    private String corpName;

    @Column(name = "certificate_sno", columnDefinition = "varchar(128) comment '法人机构代码'")
    private String certificateSno;

    @Column(name = "certificate_key", columnDefinition = "varchar(128) comment '法人机构代码散列值'", nullable = false)
    private String certificateKey;

    @Column(name = "corp_type", columnDefinition = "varchar(64) comment '法人类型'")
    private String corpType;

    @Column(name = "legal_mobile", columnDefinition = "varchar(64) comment '法人代表人手机号'")
    private String legalMobile;

    @Column(name = "legal_name", columnDefinition = "varchar(64) comment '法定代表人姓名'")
    private String legalName;

    @Column(name = "legal_certno", columnDefinition = "varchar(64) comment '法定代表人证件号'")
    private String legalCertno;

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
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
