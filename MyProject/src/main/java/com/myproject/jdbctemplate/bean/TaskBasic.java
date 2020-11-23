package com.myproject.jdbctemplate.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 事项基本信息表
 */

@Entity
@Data
@Table(name = "igt_task_basic")
@org.hibernate.annotations.Table(appliesTo = "igt_task_basic", comment = "事项基本信息表")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskBasic {

    @Id
    @Column(name = "id", columnDefinition = "bigint(20) comment '雪花算法生成的ID'", nullable = false)
    private Long id;

    @Column(name = "version", columnDefinition = "int(10) comment '版本号' default 1", nullable = false)
    private Integer version;

    @Column(name = "create_time", columnDefinition = "datetime comment '创建时间'", nullable = false)
    private LocalDateTime createTime;

    @Column(name = "create_user_id", columnDefinition = "bigint(20) comment '创建人ID'", nullable = false)
    private Long createUserId;

    @Column(name = "create_org_id", columnDefinition = "bigint(20) comment '创建机构ID'", nullable = false)
    private Long createOrgId;

    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "update_user_id", columnDefinition = "bigint(20) comment '更新人ID'", nullable = false)
    private Long updateUserId;

    @Column(name = "update_org_id", columnDefinition = "bigint(20) comment '更新机构ID'", nullable = false)
    private Long updateOrgId;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '业务办理项唯一标识'")
    private String taskGuid;

    @Column(name = "catalog_code", columnDefinition = "varchar(12) comment '基本编码'")
    private String catalogCode;

    @Column(name = "catalog_name", columnDefinition = "varchar(200) comment '目录名称'")
    private String catalogName;

    @Column(name = "local_catalog_code", columnDefinition = "varchar(50) comment '地方基本编码'")
    private String localCatalogCode;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'")
    private String taskCode;

    @Column(name = "local_task_code", columnDefinition = "varchar(50) comment '地方实施编码'")
    private String localTaskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "task_name", columnDefinition = "varchar(1000) comment '业务办理项名称，事项名称'")
    private String taskName;

    @Column(name = "dept_name", columnDefinition = "varchar(200) comment '实施主体名称'")
    private String deptName;

    @Column(name = "dept_code", columnDefinition = "varchar(50) comment '实施主体编码'")
    private String deptCode;

    @Column(name = "dept_type", columnDefinition = "varchar(2) comment '实施主体性质'")
    private String deptType;

    @Column(name = "task_type", columnDefinition = "varchar(2) comment '事项类型'")
    private String taskType;

    @Column(name = "task_version", columnDefinition = "int(10) comment '事项版本'")
    private Integer taskVersion;

    @Column(name = "task_state", columnDefinition = "varchar(2) comment '事项状态'")
    private String taskState;

    @Column(name = "use_level", columnDefinition = "varchar(11) comment '行使层级'")
    private String useLevel;

    @Column(name = "project_type", columnDefinition = "varchar(2) comment '办件类型'")
    private String projectType;

    @Column(name = "handle_type", columnDefinition = "varchar(5) comment '办理形式'")
    private String handleType;

    @Column(name = "server_type", columnDefinition = "varchar(32) comment '服务对象'")
    private String serverType;

    @Column(name = "link_way", columnDefinition = "varchar(256) comment '咨询方式'")
    private String linkWay;

    @Column(name = "transact_addr", columnDefinition = "varchar(500) comment '办理地点'")
    private String transactAddr;

    @Column(name = "transact_time", columnDefinition = "varchar(500) comment '办理时间'")
    private String transactTime;

    @Column(name = "power_source", columnDefinition = "varchar(2) comment '权力来源'")
    private String powerSource;

    @Column(name = "promise_day", columnDefinition = "int(11) comment '承诺办结时限'")
    private Integer promiseDay;

    @Column(name = "is_schedule", columnDefinition = "varchar(2) comment '是否支持预约办理'")
    private String isSchedule;

    @Column(name = "is_pay_online", columnDefinition = "varchar(2) comment '是否支持网上支付'")
    private String isPayOnline;

    @Column(name = "is_express", columnDefinition = "varchar(2) comment '是否支持物流快递'")
    private String isExpress;

    @Column(name = "is_entry_center", columnDefinition = "varchar(2) comment '是否进驻政务大厅'")
    private String isEntryCenter;

    @Column(name = "is_online", columnDefinition = "varchar(2) comment '是否网办'")
    private String isOnline;

    @Column(name = "is_service_terminals", columnDefinition = "varchar(2) comment '是否支持自助终端办理'")
    private String isServiceTerminals;

//    @Column(name = "is_window", columnDefinition = "varchar(2) comment '是否支持综窗办理'")
//    private String isWindow;
//
//    @Column(name = "is_batch", columnDefinition = "varchar(2) comment '是否支持批量接件'")
//    private String isBatch;
//
//    @Column(name = "result_group_code", columnDefinition = "varchar(50) comment '审批结果分组代码'")
//    private String resultGroupCode;
}
