package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "up_pro_result")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "handle_user_name", columnDefinition = "varchar(100) comment '受理人员'")
    private String handleUserName;

    @Column(name = "result_date", columnDefinition = "datetime comment '办结时间'", nullable = false)
    private String resultDate;

    @Column(name = "result_type", columnDefinition = "varchar(2) comment '办结结果'", nullable = false)
    private String resultType;

    @Column(name = "result_cetr_name", columnDefinition = "longtext comment '结果证照名称'")
    private String resultCetrName;

    @Column(name = "result_cetr_no", columnDefinition = "varchar(2000) comment '结果证照编号'")
    private String resultCetrNo;

    @Column(name = "result_explain", columnDefinition = "varchar(2000) comment '办件结果描述'")
    private String resultExplain;

    @Column(name = "is_delivery_results", columnDefinition = "varchar(2) comment '是否快递递送结果'", nullable = false)
    private String isDeliveryResults;

    @Column(name = "satisfaction", columnDefinition = "varchar(2) comment '满意度'")
    private String satisfaction;

    @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
    private String remark;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
