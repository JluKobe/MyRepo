package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "up_zone_organization")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpZoneOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "org_name", columnDefinition = "varchar(100) comment '部门名称'", nullable = false)
    private String orgName;

    @Column(name = "org_short_name", columnDefinition = "varchar(50) comment '部门简称'", nullable = false)
    private String orgShortName;

    @Column(name = "org_code", columnDefinition = "varchar(9) comment '组织机构代码'")
    private String orgCode;

    @Column(name = "credit_code", columnDefinition = "varchar(18) comment '统一社会信用代码'", nullable = false)
    private String creditCode;

    @Column(name = "exist_task", columnDefinition = "varchar(2) comment '部门是否存在并且行使政务服务事项'", nullable = false)
    private String existTask;

    @Column(name = "order_num", columnDefinition = "int(11) comment '排序'", nullable = false)
    private String orderNum;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
