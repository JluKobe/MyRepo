package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "dn_audit_item_condition")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnAuditItemCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(50) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "condition_name", columnDefinition = "varchar(50) comment '情形名称'", nullable = false)
    private String conditionName;

    @Column(name = "condition_desc", columnDefinition = "varchar(500) comment '情形描述' default null")
    private String conditionDesc;

    @Column(name = "bs", columnDefinition = "varchar(2) comment '区分标识'", nullable = false)
    private String bs;

    @Column(name = "order_num", columnDefinition = "int(11) comment '情形排序'", nullable = false)
    private String orderNum;

    @Column(name = "area_code", columnDefinition = "varchar(20) comment '区划'", nullable = false)
    private String areaCode;
}
