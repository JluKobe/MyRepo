/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:27:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_province_user
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_province_user`;
CREATE TABLE `up_uc_province_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `cert_eff_date` varchar(8) DEFAULT NULL COMMENT '证件有效日期',
  `cert_ext_date` varchar(8) DEFAULT NULL COMMENT '证件失效日期',
  `cert_key` varchar(128) NOT NULL COMMENT '证件散列码',
  `cert_no` varchar(64) DEFAULT NULL COMMENT '证件编号',
  `cert_type` varchar(6) DEFAULT NULL COMMENT '证件类型',
  `create_time` varchar(20) NOT NULL COMMENT '注册时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `user_alipay` varchar(64) DEFAULT NULL COMMENT '用户支付宝',
  `user_birthday` varchar(8) DEFAULT NULL COMMENT '用户生日',
  `user_edu` varchar(64) DEFAULT NULL COMMENT '用户学历',
  `user_home_address` varchar(128) DEFAULT NULL COMMENT '用户户籍地址',
  `user_life_address` varchar(128) DEFAULT NULL COMMENT '用户居住地址',
  `user_mail` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `user_mobile` varchar(64) DEFAULT NULL COMMENT '用户手机号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `user_real_lvl` varchar(64) NOT NULL COMMENT '用户实名等级',
  `user_region` varchar(6) NOT NULL COMMENT '用户来源区别',
  `user_sex` varchar(6) DEFAULT NULL COMMENT '用户性别',
  `user_ssi_location` varchar(128) DEFAULT NULL COMMENT '发卡地',
  `user_ssi_no` varchar(64) DEFAULT NULL COMMENT '社保卡号',
  `user_weixin` varchar(64) DEFAULT NULL COMMENT '用户微信',
  `user_work` varchar(128) DEFAULT NULL COMMENT '用户工作单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
