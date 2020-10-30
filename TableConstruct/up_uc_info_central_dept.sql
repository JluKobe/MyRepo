/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:27:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_info_central_dept
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_info_central_dept`;
CREATE TABLE `up_uc_info_central_dept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `begin_date` varchar(20) DEFAULT NULL COMMENT '期限起始',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '法人标识',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_date` varchar(20) DEFAULT NULL COMMENT '期限结束',
  `fund_source` varchar(64) DEFAULT NULL COMMENT '经费来源',
  `reg_address` varchar(128) DEFAULT NULL COMMENT '注册地址',
  `reg_authority` varchar(128) DEFAULT NULL COMMENT '登记管理机关',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `reg_money` varchar(12) DEFAULT NULL COMMENT '开办资金',
  `reg_organizer` varchar(128) DEFAULT NULL COMMENT '举办单位',
  `reg_range` varchar(2000) DEFAULT NULL COMMENT '宗旨和业务范围',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
