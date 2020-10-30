/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:22:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_task_general_fee_project
-- ----------------------------
DROP TABLE IF EXISTS `dn_task_general_fee_project`;
CREATE TABLE `dn_task_general_fee_project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `by_law` longtext COMMENT '收费依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `desc_explain` longtext COMMENT '允许减免依据',
  `fee_name` varchar(200) NOT NULL COMMENT '收费项目名称',
  `fee_stand` longtext NOT NULL COMMENT '收费标准',
  `is_desc` varchar(2) DEFAULT NULL COMMENT '是否允许减免',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(36) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
