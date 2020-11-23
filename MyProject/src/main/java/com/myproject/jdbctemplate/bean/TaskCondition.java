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
 * 事项情形表
 */

@Entity
@Data
@Table(name = "igt_task_condition")
@org.hibernate.annotations.Table(appliesTo = "igt_task_condition", comment = "事项情形表")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TaskCondition {

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

    @Column(name = "condition_guid", columnDefinition = "varchar(50) comment '情形唯一标识'")
    private String conditionGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '业务办理项唯一标识'")
    private String taskGuid;

    @Column(name = "condition_name", columnDefinition = "varchar(50) comment '情形名称'")
    private String conditionName;

    @Column(name = "condition_desc", columnDefinition = "varchar(500) comment '情形描述'")
    private String conditionDesc;
}
