package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 事业单位法人信息
 */

@Entity
@Data
@Table(name = "up_uc_info_central_dept")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcInfoCentralDept {
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

    @Column(name = "reg_range", columnDefinition = "varchar(2000) comment '宗旨和业务范围'")
    private String regRange;

    @Column(name = "reg_organizer", columnDefinition = "varchar(128) comment '举办单位'")
    private String regOrganizer;

    @Column(name = "reg_address", columnDefinition = "varchar(128) comment '注册地址'")
    private String regAddress;

    @Column(name = "reg_date", columnDefinition = "varchar(20) comment '注册时间'")
    private String regDate;

    @Column(name = "reg_money", columnDefinition = "varchar(12) comment '开办资金'")
    private String regMoney;

    @Column(name = "reg_authority", columnDefinition = "varchar(128) comment '登记管理机关'")
    private String regAuthority;

    @Column(name = "fund_source", columnDefinition = "varchar(64) comment '经费来源'")
    private String fundSource;

    @Column(name = "begin_date", columnDefinition = "varchar(20) comment '期限起始'")
    private String beginDate;

    @Column(name = "end_date", columnDefinition = "varchar(20) comment '期限结束'")
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
