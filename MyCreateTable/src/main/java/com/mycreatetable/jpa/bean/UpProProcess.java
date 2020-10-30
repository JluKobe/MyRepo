package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "up_pro_process")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "event_name", columnDefinition = "varchar(2) comment '业务动作'", nullable = false)
    private String eventName;

    @Column(name = "process_name", columnDefinition = "varchar(1000) comment '办理环节名称'", nullable = false)
    private String processName;

    @Column(name = "handle_user_name", columnDefinition = "varchar(100) comment '受理人员'", nullable = false)
    private String handleUserName;

    @Column(name = "handle_explain", columnDefinition = "varchar(2000) comment '办理意见'", nullable = false)
    private String handleExplain;

    @Column(name = "event_start_time", columnDefinition = "datetime comment '环节开始时间'", nullable = false)
    private String eventStartTime;

    @Column(name = "event_end_time", columnDefinition = "datetime comment '环节结束时间'", nullable = false)
    private String eventEndTime;

    @Column(name = "remark", columnDefinition = "longtext comment '备注'")
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
