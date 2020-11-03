package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "dn_audit_material_condition")
@org.hibernate.annotations.Table(appliesTo = "dn_audit_material_condition", comment = "情形下材料详情表")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnAuditMaterialCondition {
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

    @Column(name = "condition_guid", columnDefinition = "varchar(50) comment '情形唯一标识'", nullable = false)
    private String conditionGuid;

    @Column(name = "material_guid", columnDefinition = "varchar(50) comment '材料唯一标识'", nullable = false)
    private String materialGuid;

    @Column(name = "condition_desc", columnDefinition = "varchar(500) comment '情形描述' default null")
    private String conditionDesc;

    @Column(name = "bs", columnDefinition = "varchar(2) comment '区分标识'", nullable = false)
    private String bs;

    @Column(name = "area_code", columnDefinition = "varchar(20) comment '区划'", nullable = false)
    private String areaCode;
}
