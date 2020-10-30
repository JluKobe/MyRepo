package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息 异常数据
 */

@Entity
@Data
@Table(name = "dn_uc_adult_abnormal")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DnUcAdultAbnormal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "row_guid", columnDefinition = "varchar(50) comment '记录唯一标识'", nullable = false)
    private String rowGuid;

    @Column(name = "table_name", columnDefinition = "varchar(50) comment '数据表中文名'", nullable = false)
    private String tableName;

    @Column(name = "table_sql_name", columnDefinition = "varchar(50) comment '数据表英文名'", nullable = false)
    private String tableSqlName;

    @Column(name = "table_row_guid", columnDefinition = "varchar(50) comment '数据表主键'", nullable = false)
    private String tableRowGuid;

    @Column(name = "err_type", columnDefinition = "varchar(100) comment '异常类型'", nullable = false)
    private String errType;

    @Column(name = "table_cd_time", columnDefinition = "datetime comment '上传日期'", nullable = false)
    private String tableCdTime;

    @Column(name = "table_update_time", columnDefinition = "datetime comment '进入汇聚区日期'", nullable = false)
    private String tableUpdateTime;

    @Column(name = "table_cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String tableCdBatch;

    @Column(name = "table_cd_source", columnDefinition = "varchar(10) comment '数据来源'", nullable = false)
    private String tableCdSource;

    @Column(name = "remark", columnDefinition = "varchar(1000) comment '备注'")
    private String remark;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;
}
