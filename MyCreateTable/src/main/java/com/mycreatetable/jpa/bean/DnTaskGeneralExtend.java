package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 许可、给付、奖励、确认、裁决、其他类事项 扩展信息
 */

@Entity
@Data
@Table(name = "dn_task_general_extend")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnTaskGeneralExtend {
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

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "is_Entry_center", columnDefinition = "varchar(2) comment '是否进驻政务大厅'", nullable = false)
    private String isEntryCenter;

    @Column(name = "handle_area", columnDefinition = "varchar(2) comment '通办范围'")
    private String handleArea;

    @Column(name = "other_dept", columnDefinition = "varchar(200) comment '联办机构'")
    private String otherDept;

    @Column(name = "service_type", columnDefinition = "varchar(500) comment '中介服务'")
    private String serviceType;

    @Column(name = "limit_explain", columnDefinition = "varchar(256) comment '数量限制'")
    private String limitExplain;

    @Column(name = "result_type", columnDefinition = "varchar(30) comment '审批结果类型'", nullable = false)
    private String resultType;

    @Column(name = "result_name", columnDefinition = "varchar(200) comment '审批结果名称'")
    private String resultName;

    @Column(name = "result_guid", columnDefinition = "varchar(256) comment '审批结果样本'")
    private String resultGuid;

    @Column(name = "is_schedule", columnDefinition = "varchar(2) comment '是否支持预约办理'")
    private String isSchedule;

    @Column(name = "is_pay_online", columnDefinition = "varchar(2) comment '是否支持网上支付'", nullable = false)
    private String isPayOnline;

    @Column(name = "is_express", columnDefinition = "varchar(2) comment '是否支持物流快递'", nullable = false)
    private String isExpress;

    @Column(name = "is_service_terminals", columnDefinition = "varchar(2) comment '是否支持终端办理'")
    private String isServiceTerminals;

    @Column(name = "user_topic_type", columnDefinition = "varchar(40) comment '面向自然人事项主题分类'")
    private String userTopicType;

    @Column(name = "user_character_topic_type", columnDefinition = "varchar(100) comment '面向自然人地方特色主题分类'")
    private String userCharacterTopicType;

    @Column(name = "corp_topic_type", columnDefinition = "varchar(40) comment '面向自然人事项主题分类'")
    private String corpTopicType;

    @Column(name = "corp_character_topic_type", columnDefinition = "varchar(100) comment '面向自然人地方特色主题分类'")
    private String corpCharacterTopicType;

    @Column(name = "is_online", columnDefinition = "varchar(2) comment '是否网办'", nullable = false)
    private String isOnline;

    @Column(name = "online_handle_depth", columnDefinition = "varchar(20) comment '网上办理深度'")
    private String onlineHandleDepth;

    @Column(name = "online_handle_url", columnDefinition = "varchar(256) comment '网办地址'")
    private String onlineHandleUrl;

    @Column(name = "limit_scene_explain", columnDefinition = "varchar(1000) comment '办理现场办理原因说明'")
    private String limitSceneExplain;

    @Column(name = "town_name", columnDefinition = "varchar(200) comment '乡镇街道名称'")
    private String townName;

    @Column(name = "town_code", columnDefinition = "varchar(18) comment '乡镇街道代码'")
    private String townCode;

    @Column(name = "village_name", columnDefinition = "varchar(200) comment '村居社区名称'")
    private String villageName;

    @Column(name = "village_code", columnDefinition = "varchar(18) comment '村居社区代码'")
    private String villageCode;

    @Column(name = "extend_field", columnDefinition = "varchar(2000) comment '扩展字段'")
    private String extendField;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
