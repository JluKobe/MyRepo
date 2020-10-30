package com.mycreatetable.jpa.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 用户信息数据 自然人信息资料表
 */

@Entity
@Data
@Table(name = "up_uc_province_user")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpUcProvinceUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增组件
    @Column(name = "id", columnDefinition = "bigint(20) comment '主键'", nullable = false)
    private Long id;

    @Column(name = "cert_type", columnDefinition = "varchar(6) comment '证件类型'")
    private String certType;

    @Column(name = "cert_no", columnDefinition = "varchar(64) comment '证件编号'")
    private String certNo;

    @Column(name = "cert_key", columnDefinition = "varchar(128) comment '证件散列码'", nullable = false)
    private String certKey;

    @Column(name = "cert_eff_date", columnDefinition = "varchar(8) comment '证件有效日期'")
    private String certEffDate;

    @Column(name = "cert_ext_date", columnDefinition = "varchar(8) comment '证件失效日期'")
    private String certExtDate;

    @Column(name = "create_time", columnDefinition = "varchar(20) comment '注册时间'", nullable = false)
    private String createTime;

    @Column(name = "user_name", columnDefinition = "varchar(64) comment '用户名称'")
    private String userName;

    @Column(name = "user_mobile", columnDefinition = "varchar(64) comment '用户手机号'")
    private String userMobile;

    @Column(name = "user_real_lvl", columnDefinition = "varchar(64) comment '用户实名等级'", nullable = false)
    private String userRealLvl;

    @Column(name = "user_birthday", columnDefinition = "varchar(8) comment '用户生日'")
    private String userBirthday;

    @Column(name = "user_sex", columnDefinition = "varchar(6) comment '用户性别'")
    private String userSex;

    @Column(name = "user_edu", columnDefinition = "varchar(64) comment '用户学历'")
    private String userEdu;

    @Column(name = "user_mail", columnDefinition = "varchar(64) comment '用户邮箱'")
    private String userMail;

    @Column(name = "user_alipay", columnDefinition = "varchar(64) comment '用户支付宝'")
    private String userAlipay;

    @Column(name = "user_weixin", columnDefinition = "varchar(64) comment '用户微信'")
    private String userWeixin;

    @Column(name = "user_home_address", columnDefinition = "varchar(128) comment '用户户籍地址'")
    private String userHomeAddress;

    @Column(name = "user_life_address", columnDefinition = "varchar(128) comment '用户居住地址'")
    private String userLifeAddress;

    @Column(name = "user_work", columnDefinition = "varchar(128) comment '用户工作单位'")
    private String userWork;

    @Column(name = "user_region", columnDefinition = "varchar(6) comment '用户来源区别'", nullable = false)
    private String userRegion;

    @Column(name = "user_ssi_no", columnDefinition = "varchar(64) comment '社保卡号'")
    private String userSsiNo;

    @Column(name = "user_ssi_location", columnDefinition = "varchar(128) comment '发卡地'")
    private String userSsiLocation;

    @Column(name = "cd_operation", columnDefinition = "varchar(2) comment '同步类型'", nullable = false)
    private String cdOperation;

    @Column(name = "cd_time", columnDefinition = "datetime comment '同步时间'", nullable = false)
    private String cdTime;

    @Column(name = "cd_batch", columnDefinition = "varchar(32) comment '批次号'", nullable = false)
    private String cdBatch;

    @Column(name = "data_source", columnDefinition = "varchar(3) comment '数据来源'", nullable = false)
    private String dataSource;
}
