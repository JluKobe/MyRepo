package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 电子证照共享异常数据 目录信息
 */

@Entity
@Data
@Table(name = "dn_lic_data_error")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnLicDataError {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "certificate_source_id", columnDefinition = "varchar(128) comment '电子证照源标识'", nullable = false)
    private String certificateSourceId;

    @Column(name = "certificate_name", columnDefinition = "varchar(512) comment '证照名称'", nullable = false)
    private String certificateName;

    @Column(name = "certificate_type", columnDefinition = "varchar(256) comment '证照类型名称'", nullable = false)
    private String certificateType;

    @Column(name = "certificate_type_code", columnDefinition = "varchar(64) comment '证照类型代码'", nullable = false)
    private String certificateTypeCode;

    @Column(name = "issue_dept", columnDefinition = "longtext comment '证照颁发机构'", nullable = false)
    private String issueDept;

    @Column(name = "issue_dept_code", columnDefinition = "longtext comment '证照颁发机构代码'", nullable = false)
    private String issueDeptCode;

    @Column(name = "certificate_area_code", columnDefinition = "varchar(32) comment '证照所属管辖属地编码'", nullable = false)
    private String certificateAreaCode;

    @Column(name = "certificate_holder", columnDefinition = "longtext comment '持证主体'", nullable = false)
    private String certificateHolder;

    @Column(name = "certificate_holder_code", columnDefinition = "longtext comment '持证主体代码'", nullable = false)
    private String certificateHolderCode;

    @Column(name = "certificate_holder_type", columnDefinition = "varchar(2000) comment '持证主体代码类型'")
    private String certificateHolderType;

    @Column(name = "certificate_number", columnDefinition = "varchar(128) comment '证照编码'", nullable = false)
    private String certificateNumber;

    @Column(name = "issue_date", columnDefinition = "varchar(32) comment '证照颁发日期'", nullable = false)
    private String issueDate;

    @Column(name = "error_remark", columnDefinition = "varchar(512) comment '异常说明'", nullable = false)
    private String errorRemark;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
