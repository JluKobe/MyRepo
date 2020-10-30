package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 许可、给付、奖励、确认、裁决、其他类事项 收费项目信息
 */

@Entity
@Data
@Table(name = "dn_task_general_fee_project")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnTaskGeneralFeeProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(36) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "fee_name", columnDefinition = "varchar(200) comment '收费项目名称'", nullable = false)
    private String feeName;

    @Column(name = "fee_stand", columnDefinition = "longtext comment '收费标准'", nullable = false)
    private String feeStand;

    @Column(name = "by_law", columnDefinition = "longtext comment '收费依据'")
    private String byLaw;

    @Column(name = "is_desc", columnDefinition = "varchar(2) comment '是否允许减免'")
    private String isDesc;

    @Column(name = "desc_explain", columnDefinition = "longtext comment '允许减免依据'")
    private String descExplain;

    @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
    private String remark;

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
