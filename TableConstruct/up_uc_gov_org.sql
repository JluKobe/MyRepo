/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:26:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_gov_org
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_gov_org`;
CREATE TABLE `up_uc_gov_org` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `oper_eff_date` varchar(20) DEFAULT NULL COMMENT '经营期限-起始',
  `oper_exp_date` varchar(20) DEFAULT NULL COMMENT '经营期限-结束',
  `org_cc_code` varchar(128) NOT NULL COMMENT '统一社会信用代码',
  `org_code` varchar(64) NOT NULL COMMENT '组织机构编码',
  `org_name` varchar(256) NOT NULL COMMENT '组织机构名称',
  `org_seq` int(11) NOT NULL COMMENT '组织顺序',
  `org_status` varchar(6) NOT NULL COMMENT '组织状态',
  `org_type` varchar(64) NOT NULL COMMENT '组织机构类型',
  `parent_org_code` varchar(64) DEFAULT NULL COMMENT '上级机构组织编码',
  `reg_address` varchar(64) DEFAULT NULL COMMENT '注册地址',
  `reg_date` varchar(8) DEFAULT NULL COMMENT '注册日期',
  `region_code` varchar(64) NOT NULL COMMENT '行政区域编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
