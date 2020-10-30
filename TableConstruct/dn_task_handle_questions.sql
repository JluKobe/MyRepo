/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:23:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_task_handle_questions
-- ----------------------------
DROP TABLE IF EXISTS `dn_task_handle_questions`;
CREATE TABLE `dn_task_handle_questions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `answer` longtext NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(36) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
