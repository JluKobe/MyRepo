package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 事业单位法人信息
 */

@Entity
@Data
@Table(name = "up_uc_info_central_dept")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcInfoCentralDept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "certificate_sno", columnDefinition = "varchar(64) comment '法人标识'", nullable = false)
    private String certificateSno;

    @Column(name = "reg_range", columnDefinition = "varchar(2000) comment '宗旨和业务范围'")
    private String regRange;

    @Column(name = "reg_organizer", columnDefinition = "varchar(128) comment '举办单位'")
    private String regOrganizer;

    @Column(name = "reg_address", columnDefinition = "varchar(128) comment '注册地址'")
    private String regAddress;

    @Column(name = "reg_date", columnDefinition = "varchar(20) comment '注册时间'")
    private String regDate;

    @Column(name = "reg_money", columnDefinition = "varchar(12) comment '开办资金'")
    private String regMoney;

    @Column(name = "reg_authority", columnDefinition = "varchar(128) comment '登记管理机关'")
    private String regAuthority;

    @Column(name = "fund_source", columnDefinition = "varchar(64) comment '经费来源'")
    private String fundSource;

    @Column(name = "begin_date", columnDefinition = "varchar(20) comment '期限起始'")
    private String beginDate;

    @Column(name = "end_date", columnDefinition = "varchar(20) comment '期限结束'")
    private String endDate;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
