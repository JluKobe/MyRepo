package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 企业法人信息
 */

@Entity
@Data
@Table(name = "up_uc_info_enterprise")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcInfoEnterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "certificate_sno", columnDefinition = "varchar(64) comment '法人标识'", nullable = false)
    private String certificateSno;

    @Column(name = "enterprise_address", columnDefinition = "varchar(128) comment '企业机构注册地址'")
    private String enterpriseAddress;

    @Column(name = "enterprise_capital", columnDefinition = "varchar(12) comment '企业机构注册金额'")
    private String enterpriseCapital;

    @Column(name = "enterprise_range", columnDefinition = "varchar(4000) comment '企业机构经营范围'")
    private String enterpriseRange;

    @Column(name = "enterprise_register_date", columnDefinition = "varchar(20) comment '企业机构注册日期'")
    private String enterpriseRegisterDate;

    @Column(name = "enterprise_industry", columnDefinition = "varchar(64) comment '行业类型'")
    private String enterpriseIndustry;

    @Column(name = "enterprise_small_class", columnDefinition = "varchar(64) comment '行业小类'")
    private String enterpriseSmallClass;

    @Column(name = "enterprise_begin_date", columnDefinition = "varchar(20) comment '营业限期起始'")
    private String enterpriseBeginDate;

    @Column(name = "enterprise_end_date", columnDefinition = "varchar(20) comment '营业限期截止'")
    private String enterpriseEndDate;

    @Column(name = "enterprise_approval_date", columnDefinition = "varchar(20) comment '核准日期'")
    private String enterpriseApprovalDate;

    @Column(name = "enterprise_approver_agency", columnDefinition = "varchar(64) comment '核准机构'")
    private String enterpriseApproverAgency;

    @Column(name = "create_date", columnDefinition = "varchar(20) comment '创建时间'", nullable = false)
    private String createDate;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
