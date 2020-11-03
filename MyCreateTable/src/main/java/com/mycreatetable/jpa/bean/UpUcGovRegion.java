package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 行政区域
 */

@Entity
@Data
@Table(name = "up_uc_gov_region")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcGovRegion {
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

    @Column(name = "region_code", columnDefinition = "varchar(64) comment '行政区域代码'", nullable = false)
    private String regionCode;

    @Column(name = "region_name", columnDefinition = "varchar(256) comment '行政区域名称'", nullable = false)
    private String regionName;

    @Column(name = "region_desc", columnDefinition = "varchar(512) comment '行政区域描述'")
    private String regionDesc;

    @Column(name = "parent_region_code", columnDefinition = "varchar(64) comment '上级行政区域代码'", nullable = false)
    private String parentRegionCode;

    @Column(name = "region_lvl", columnDefinition = "varchar(6) comment '行政区域登记'", nullable = false)
    private String regionLvl;

    @Column(name = "nation", columnDefinition = "varchar(20) comment '国家'", nullable = false)
    private String nation;

    @Column(name = "province", columnDefinition = "varchar(20) comment '省'", nullable = false)
    private String province;

    @Column(name = "city", columnDefinition = "varchar(20) comment '地市'")
    private String city;

    @Column(name = "county", columnDefinition = "varchar(20) comment '县'")
    private String county;

    @Column(name = "town", columnDefinition = "varchar(20) comment '镇'")
    private String town;

    @Column(name = "region_req", columnDefinition = "varchar(64) comment '区域顺序'", nullable = false)
    private String regionReq;

    @Column(name = "region_status", columnDefinition = "varchar(6) comment '区域状态'", nullable = false)
    private String regionStatus;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
