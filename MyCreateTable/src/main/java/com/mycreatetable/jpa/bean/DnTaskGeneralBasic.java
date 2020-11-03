package com.mycreatetable.jpa.bean;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 许可、给付、奖励、确认、裁决、其他类事项 基本信息
 */

@Entity
@Data
@Table(name = "dn_task_general_basic")
@org.hibernate.annotations.Table(appliesTo = "dn_task_general_basic", comment = "许可、给付、奖励、确认、裁决、其他类事项 基本信息")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnTaskGeneralBasic {
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

    @Column(name = "tenant_id", columnDefinition = "bigint(20) comment '租户ID'", nullable = false)
    private Long tenantId;

    @Column(name = "update_time", columnDefinition = "datetime comment '更新时间'", nullable = false)
    private LocalDateTime updateTime;

    @Column(name = "update_user_id", columnDefinition = "bigint(20) comment '更新人ID'", nullable = false)
    private Long updateUserId;

    @Column(name = "update_org_id", columnDefinition = "bigint(20) comment '更新机构ID'", nullable = false)
    private Long updateOrgId;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_name", columnDefinition = "varchar(1000) comment '事项名称'", nullable = false)
    private String taskName;

    @Column(name = "catalog_code", columnDefinition = "varchar(12) comment '基本编码'", nullable = false)
    private String catalogCode;

    @Column(name = "task_type", columnDefinition = "varchar(2) comment '事项类型'", nullable = false)
    private String taskType;

    @Column(name = "by_law", columnDefinition = "varchar(256) comment '设定依据'", nullable = false)
    private String byLaw;

    @Column(name = "power_source", columnDefinition = "varchar(2) comment '权力来源'", nullable = false)
    private String powerSource;

    @Column(name = "use_level", columnDefinition = "varchar(11) comment '行使层级'", nullable = false)
    private String useLevel;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "task_state", columnDefinition = "varchar(2) comment '事项状态'", nullable = false)
    private String taskState;

    @Column(name = "task_version", columnDefinition = "int(10) comment '事项版本'", nullable = false)
    private Integer taskVersion;

    @Column(name = "dept_name", columnDefinition = "varchar(200) comment '实施主体'", nullable = false)
    private String deptName;

    @Column(name = "dept_type", columnDefinition = "varchar(2) comment '实施主体性质'", nullable = false)
    private String deptType;

    @Column(name = "dept_code", columnDefinition = "varchar(50) comment '实施主体编码'", nullable = false)
    private String deptCode;

    @Column(name = "entrust_name", columnDefinition = "varchar(100) comment '委托部门'")
    private String entrustName;

    @Column(name = "anticipate_day", columnDefinition = "int(11) comment '法定办结时限'", nullable = false)
    private Integer anticipateDay;

    @Column(name = "anticipate_type", columnDefinition = "varchar(2) comment '法定办结时限单位'", nullable = false)
    private String anticipateType;

    @Column(name = "anticipate_explain", columnDefinition = "varchar(256) comment '法定办结时限说明'")
    private String anticipateExplain;

    @Column(name = "promise_day", columnDefinition = "int(11) comment '承诺办结时限'", nullable = false)
    private Integer promiseDay;

    @Column(name = "promise_type", columnDefinition = "int(2) comment '承诺办结时限单位'", nullable = false)
    private Integer promiseType;

    @Column(name = "promise_explain", columnDefinition = "varchar(256) comment '承诺办结时限说明'")
    private String promiseExplain;

    @Column(name = "accept_condition", columnDefinition = "varchar(256) comment '受理条件'", nullable = false)
    private String acceptCondition;

    @Column(name = "handle_flow", columnDefinition = "varchar(256) comment '办理流程'", nullable = false)
    private String handleFlow;

    @Column(name = "is_fee", columnDefinition = "varchar(2) comment '是否收费'", nullable = false)
    private String isFee;

    @Column(name = "fee_basis", columnDefinition = "varchar(256) comment '收费依据'")
    private String feeBasis;

    @Column(name = "server_type", columnDefinition = "varchar(32) comment '服务对象'", nullable = false)
    private String serverType;

    @Column(name = "project_type", columnDefinition = "varchar(2) comment '办件类型'", nullable = false)
    private String projectType;

    @Column(name = "handle_type", columnDefinition = "varchar(5) comment '办理形式'")
    private String handleType;

    @Column(name = "limit_scene_num", columnDefinition = "int(11) comment '到办事现场次数'", nullable = false)
    private Integer limitSceneNum;

    @Column(name = "special_procedure", columnDefinition = "varchar(500) comment '特别程序'", nullable = false)
    private String specialProcedure;

    @Column(name = "app_is_single_login", columnDefinition = "varchar(2) comment '移动端是否对接单点登录'", nullable = false)
    private String appIsSingleLogin;

    @Column(name = "mobile_terminal_url", columnDefinition = "varchar(500) comment '移动端办理地址'")
    private String mobileTerminalUrl;

    @Column(name = "is_single_login", columnDefinition = "varchar(2) comment '计算机端是否对接单点登录'", nullable = false)
    private String isSingleLogin;

    @Column(name = "link_addr", columnDefinition = "varchar(256) comment '计算机端在线办理跳转地址'")
    private String linkAddr;

    @Column(name = "transact_addr", columnDefinition = "varchar(500) comment '办理地点'", nullable = false)
    private String transactAddr;

    @Column(name = "transact_time", columnDefinition = "varchar(500) comment '办理时间'", nullable = false)
    private String transactTime;

    @Column(name = "link_way", columnDefinition = "varchar(256) comment '咨询方式'", nullable = false)
    private String linkWay;

    @Column(name = "supervise_way", columnDefinition = "varchar(256) comment '监督投诉方式'", nullable = false)
    private String superviseWay;

    @Column(name = "plan_effective_date", columnDefinition = "datetime comment '计划生效日期'")
    private LocalDateTime planEffectiveDate;

    @Column(name = "plan_cancel_date", columnDefinition = "datetime comment '计划取消日期'")
    private LocalDateTime planCancelDate;

    @Column(name = "local_catalog_code", columnDefinition = "varchar(50) comment '地方基本编码' default null")
    private String localCatalogCode;

    @Column(name = "local_task_code", columnDefinition = "varchar(50) comment '地方实施编码' default null")
    private String localTaskCode;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private LocalDateTime cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
