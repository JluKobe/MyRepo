package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 政务服务事项办件信息 材料目录信息
 */

@Entity
@Data
@Table(name = "up_pro_material")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpProMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "project_no", columnDefinition = "varchar(50) comment '办件编号'", nullable = false)
    private String projectNo;

    @Column(name = "material_name", columnDefinition = "varchar(200) comment '材料名称'", nullable = false)
    private String materialName;

    @Column(name = "get_type", columnDefinition = "varchar(2) comment '收取方式'")
    private String getType;

    @Column(name = "get_name", columnDefinition = "varchar(5) comment '收取数量'")
    private String getName;

    @Column(name = "material_attach_name", columnDefinition = "varchar(200) comment '附件名称'")
    private String materialAttachName;

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
