/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_pro_material
-- ----------------------------
DROP TABLE IF EXISTS `up_pro_material`;
CREATE TABLE `up_pro_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `get_name` varchar(5) DEFAULT NULL COMMENT '收取数量',
  `get_type` varchar(2) DEFAULT NULL COMMENT '收取方式',
  `material_attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
