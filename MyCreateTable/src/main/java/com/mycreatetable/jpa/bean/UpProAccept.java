package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "up_pro_accept")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProAccept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "catalog_code", columnDefinition = "varchar(12) comment '基本编码'", nullable = false)
    private String catalogCode;

    @Column(name = "local_catalog_code", columnDefinition = "varchar(50) comment '地方基本编码'")
    private String localCatalogCode;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "local_task_code", columnDefinition = "varchar(50) comment '地方实施编码'")
    private String localTaskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "task_name", columnDefinition = "varchar(1000) comment '事项名称'", nullable = false)
    private String taskName;

    @Column(name = "task_version", columnDefinition = "int(10) comment '事项版本'", nullable = false)
    private String taskVersion;

    @Column(name = "applyer_name", columnDefinition = "varchar(100) comment '申请人名称'", nullable = false)
    private String applyerName;

    @Column(name = "applyer_type", columnDefinition = "varchar(2) comment '申请人类型'", nullable = false)
    private String applyerType;

    @Column(name = "applyer_page_type", columnDefinition = "varchar(70) comment '申请人证件类型'", nullable = false)
    private String applyerPageType;

    @Column(name = "applyer_page_code", columnDefinition = "varchar(500) comment '申请人证件号码'", nullable = false)
    private String applyerPageCode;

    @Column(name = "apply_date", columnDefinition = "datetime comment '申请时间'", nullable = false)
    private String applyDate;

    @Column(name = "apply_type", columnDefinition = "varchar(2) comment '申请类型'", nullable = false)
    private String applyType;

    @Column(name = "legal", columnDefinition = "varchar(100) comment '法定代表人'")
    private String legal;

    @Column(name = "contact_name", columnDefinition = "varchar(100) comment '联系人/代理人姓名'")
    private String contactName;

    @Column(name = "contact_type", columnDefinition = "varchar(6) comment '联系人/代理人证件类型'")
    private String contactType;

    @Column(name = "contact_code", columnDefinition = "varchar(50) comment '联系人/代理人证件号码'")
    private String contactCode;

    @Column(name = "contact_mobile", columnDefinition = "varchar(11) comment '联系人手机号码'")
    private String contactMobile;

    @Column(name = "zip_code", columnDefinition = "varchar(6) comment '邮编'")
    private String zipCode;

    @Column(name = "address", columnDefinition = "varchar(1000) comment '通讯地址'")
    private String address;

    @Column(name = "org_name", columnDefinition = "varchar(100) comment '受理部门'", nullable = false)
    private String orgName;

    @Column(name = "org_code", columnDefinition = "varchar(18) comment '受理部门编码'", nullable = false)
    private String orgCode;

    @Column(name = "handle_user_name", columnDefinition = "varchar(100) comment '受理人员'")
    private String handleUserName;

    @Column(name = "accept_date", columnDefinition = "datetime comment '受理时间'", nullable = false)
    private String acceptDate;

    @Column(name = "accept_doc_no", columnDefinition = "varchar(50) comment '受理文书编号'")
    private String acceptDocNo;

    @Column(name = "project_name", columnDefinition = "varchar(1000) comment '办理摘要'")
    private String projectName;

    @Column(name = "project_type", columnDefinition = "varchar(2) comment '办理类型'", nullable = false)
    private String projectType;

    @Column(name = "promise_date", columnDefinition = "datetime comment '承诺办结时间'")
    private String promiseDate;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
