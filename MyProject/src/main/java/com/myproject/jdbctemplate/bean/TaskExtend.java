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
 * 事项扩展信息
 */

@Entity
@Data
@Table(name = "igt_task_extend")
@org.hibernate.annotations.Table(appliesTo = "igt_task_extend", comment = "事项扩展信息")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskExtend {

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

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'")
    private String taskGuid;

    @Column(name = "promise_type", columnDefinition = "varchar(2) comment '承诺办结时限单位'")
    private String promiseType;

    @Column(name = "promise_explain", columnDefinition = "varchar(256) comment '承诺办结时限说明'")
    private String promiseExplain;

    @Column(name = "anticipate_day", columnDefinition = "int(11) comment '法定办结时限'")
    private Integer anticipateDay;

    @Column(name = "anticipate_type", columnDefinition = "varchar(2) comment '法定办结时限单位'")
    private String anticipateType;

    @Column(name = "anticipate_explain", columnDefinition = "varchar(256) comment '法定办结时限说明'")
    private String anticipateExplain;

    @Column(name = "special_procedure", columnDefinition = "varchar(500) comment '特别程序'")
    private String specialProcedure;

    @Column(name = "entrust_name", columnDefinition = "varchar(100) comment '委托部门'")
    private String entrustName;

    @Column(name = "plan_effective_date", columnDefinition = "datetime comment '计划生效日期'")
    private LocalDateTime planEffectiveDate;

    @Column(name = "plan_cancel_date", columnDefinition = "datetime comment '计划取消日期'")
    private LocalDateTime planCancelDate;

    @Column(name = "by_law", columnDefinition = "varchar(256) comment '设定依据'")
    private String byLaw;

    @Column(name = "by_suppose", columnDefinition = "varchar(256) comment '补充依据'")
    private String bySuppose;

    @Column(name = "supervise_way", columnDefinition = "varchar(256) comment '监督投诉方式'")
    private String superviseWay;

    @Column(name = "app_is_single_login", columnDefinition = "varchar(2) comment '移动端是否对接单点登录'")
    private String appIsSingleLogin;

    @Column(name = "mobile_terminal_url", columnDefinition = "varchar(500) comment '移动端办理地址'")
    private String mobileTerminalUrl;

    @Column(name = "is_single_login", columnDefinition = "varchar(2) comment '计算机端是否对接单点登录'")
    private String isSingleLogin;

    @Column(name = "link_addr", columnDefinition = "varchar(256) comment '计算机端办理地址'")
    private String linkAddr;

    @Column(name = "accept_condition", columnDefinition = "varchar(256) comment '受理条件'")
    private String acceptCondition;

    @Column(name = "online_handle_depth", columnDefinition = "varchar(20) comment '网上办理深度'")
    private String onlineHandleDepth;

    @Column(name = "service_type", columnDefinition = "varchar(500) comment '中介服务'")
    private String serviceType;

    @Column(name = "other_dept", columnDefinition = "varchar(200) comment '联办机构'")
    private String otherDept;

    @Column(name = "limit_scene_num", columnDefinition = "int(11) comment '到办事现场次数'")
    private Integer limitSceneNum;

    @Column(name = "limit_scene_explain", columnDefinition = "varchar(1000) comment '必须现场办理原因说明'")
    private String limitSceneExplain;

    @Column(name = "handle_flow", columnDefinition = "varchar(256) comment '办理流程'")
    private String handleFlow;

    @Column(name = "handle_area", columnDefinition = "varchar(2) comment '通办范围'")
    private String handleArea;

    @Column(name = "online_handle_url", columnDefinition = "varchar(256) comment '网办地址'")
    private String onlineHandleUrl;

    @Column(name = "result_type", columnDefinition = "varchar(50) comment '审批结果类型代码'")
    private String resultType;

    @Column(name = "result_name", columnDefinition = "varchar(200) comment '审批结果名称'")
    private String resultName;

    @Column(name = "result_sample", columnDefinition = "varchar(200) comment '审批结果样本'")
    private String resultSample;
}
