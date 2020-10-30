/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:27:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_info_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_info_enterprise`;
CREATE TABLE `up_uc_info_enterprise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '法人标识',
  `create_date` varchar(20) DEFAULT NULL COMMENT '创建时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `enterprise_address` varchar(128) DEFAULT NULL COMMENT '企业机构注册地址',
  `enterprise_approval_date` varchar(20) DEFAULT NULL COMMENT '核准日期',
  `enterprise_approver_agency` varchar(64) DEFAULT NULL COMMENT '核准机构',
  `enterprise_begin_date` varchar(20) DEFAULT NULL COMMENT '营业限期起始',
  `enterprise_capital` varchar(12) DEFAULT NULL COMMENT '企业机构注册金额',
  `enterprise_end_date` varchar(20) DEFAULT NULL COMMENT '营业限期截止',
  `enterprise_industry` varchar(64) DEFAULT NULL COMMENT '行业类型',
  `enterprise_range` varchar(4000) DEFAULT NULL COMMENT '企业机构经营范围',
  `enterprise_register_date` varchar(20) DEFAULT NULL COMMENT '企业机构注册日期',
  `enterprise_small_class` varchar(64) DEFAULT NULL COMMENT '行业小类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
