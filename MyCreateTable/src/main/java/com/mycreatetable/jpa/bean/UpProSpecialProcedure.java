package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 政务服务事项办件信息 特别程序信息
 */

@Entity
@Data
@Table(name = "up_pro_special_procedure")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProSpecialProcedure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "special_type", columnDefinition = "varchar(2) comment '特别程序种类'", nullable = false)
    private String specialType;

    @Column(name = "special_name", columnDefinition = "varchar(1000) comment '特别程序种类名称'", nullable = false)
    private String specialName;

    @Column(name = "special_time", columnDefinition = "datetime comment '特别程序开始时间'", nullable = false)
    private String specialTime;

    @Column(name = "special_reason", columnDefinition = "varchar(2000) comment '特别程序启动理由或依据'", nullable = false)
    private String specialReason;

    @Column(name = "applyer_user_name", columnDefinition = "varchar(100) comment '申请人'")
    private String applyerUserName;

    @Column(name = "end_time", columnDefinition = "datetime comment '特别程序结束时间'", nullable = false)
    private String endTime;

    @Column(name = "result", columnDefinition = "varchar(2000) comment '特别程序结果'")
    private String result;

    @Column(name = "special_explain", columnDefinition = "varchar(2000) comment '特别程序办理意见'")
    private String specialExplain;

    @Column(name = "handle_user", columnDefinition = "varchar(100) comment '办理人'")
    private String handleUser;

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
