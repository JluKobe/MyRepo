/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:26:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_gov_staff
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_gov_staff`;
CREATE TABLE `up_uc_gov_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `cert_key` varchar(128) NOT NULL COMMENT '行政人员唯一标识',
  `cert_no` varchar(64) DEFAULT NULL COMMENT '证件号码',
  `cert_type` varchar(6) DEFAULT NULL COMMENT '证件类型',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `is_real` varchar(6) NOT NULL COMMENT '实名状态',
  `login_no` varchar(64) DEFAULT NULL COMMENT '登录账号',
  `org_id` varchar(64) DEFAULT NULL COMMENT '所在组织',
  `real_date` varchar(20) DEFAULT NULL COMMENT '实名日期',
  `real_lvl` varchar(64) NOT NULL COMMENT '实名等级',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `region_id` varchar(64) NOT NULL COMMENT '所在区域',
  `staff_code` varchar(64) NOT NULL COMMENT '人员编号',
  `staff_creater` varchar(64) NOT NULL COMMENT '创建用户',
  `staff_duty` varchar(64) DEFAULT NULL COMMENT '人员岗位',
  `staff_lvl` varchar(64) DEFAULT NULL COMMENT '人员级别',
  `staff_name` varchar(64) DEFAULT NULL COMMENT '人员名称',
  `staff_phone` varchar(64) DEFAULT NULL COMMENT '人员联系电话',
  `staff_status` varchar(6) NOT NULL COMMENT '人员状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
