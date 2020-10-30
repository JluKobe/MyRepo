package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 许可、给付、奖励、确认、裁决、其他类事项 材料目录信息
 */

@Entity
@Data
@Table(name = "dn_task_general_material")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnTaskGeneralMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "task_guid", columnDefinition = "varchar(36) comment '事项唯一标识'", nullable = false)
    private String taskGuid;

    @Column(name = "task_code", columnDefinition = "varchar(36) comment '实施编码'", nullable = false)
    private String taskCode;

    @Column(name = "task_handle_item", columnDefinition = "varchar(50) comment '业务办理项编码'")
    private String taskHandleItem;

    @Column(name = "material_name", columnDefinition = "varchar(200) comment '材料名称'", nullable = false)
    private String materialName;

    @Column(name = "material_type", columnDefinition = "varchar(2) comment '材料类型'")
    private String materialType;

    @Column(name = "material_format", columnDefinition = "varchar(2) comment '材料形式'")
    private String materialFormat;

    @Column(name = "is_need", columnDefinition = "varchar(2) comment '材料必要性'")
    private String isNeed;

    @Column(name = "form_guid", columnDefinition = "varchar(256) comment '空白表格'")
    private String formGuid;

    @Column(name = "example_guid", columnDefinition = "varchar(256) comment '示例样表'")
    private String exampleGuid;

    @Column(name = "source_type", columnDefinition = "varchar(2) comment '来源渠道'")
    private String sourceType;

    @Column(name = "source_explain", columnDefinition = "varchar(500) comment '来源渠道说明'")
    private String sourceExplain;

    @Column(name = "page_num", columnDefinition = "int(11) comment '纸质材料份数'")
    private String pageNum;

    @Column(name = "page_format", columnDefinition = "varchar(200) comment '纸质材料规格'")
    private String pageFormat;

    @Column(name = "fill_explain", columnDefinition = "varchar(500) comment '填报须知'")
    private String fillExplain;

    @Column(name = "accept_stand", columnDefinition = "longtext comment '受理标准'")
    private String acceptStand;

    @Column(name = "by_law", columnDefinition = "longtext comment '要求提供材料的依据'")
    private String byLaw;

    @Column(name = "remark", columnDefinition = "longtext comment '备注'")
    private String remark;

    @Column(name = "order_num", columnDefinition = "int(11) comment '排序'", nullable = false)
    private String orderNum;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
