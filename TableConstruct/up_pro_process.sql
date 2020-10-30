/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_pro_process
-- ----------------------------
DROP TABLE IF EXISTS `up_pro_process`;
CREATE TABLE `up_pro_process` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `event_end_time` datetime NOT NULL COMMENT '环节结束时间',
  `event_name` varchar(2) NOT NULL COMMENT '业务动作',
  `event_start_time` datetime NOT NULL COMMENT '环节开始时间',
  `handle_explain` varchar(2000) NOT NULL COMMENT '办理意见',
  `handle_user_name` varchar(100) NOT NULL COMMENT '受理人员',
  `process_name` varchar(1000) NOT NULL COMMENT '办理环节名称',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` longtext COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
