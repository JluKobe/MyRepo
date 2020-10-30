/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:22:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_task_directory
-- ----------------------------
DROP TABLE IF EXISTS `dn_task_directory`;
CREATE TABLE `dn_task_directory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `by_law` longtext NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
