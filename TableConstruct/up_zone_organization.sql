/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:27:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_zone_organization
-- ----------------------------
DROP TABLE IF EXISTS `up_zone_organization`;
CREATE TABLE `up_zone_organization` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `credit_code` varchar(18) NOT NULL COMMENT '统一社会信用代码',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `exist_task` varchar(2) NOT NULL COMMENT '部门是否存在并且行使政务服务事项',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `org_code` varchar(9) DEFAULT NULL COMMENT '组织机构代码',
  `org_name` varchar(100) NOT NULL COMMENT '部门名称',
  `org_short_name` varchar(50) NOT NULL COMMENT '部门简称',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
