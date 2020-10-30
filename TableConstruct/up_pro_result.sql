/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_pro_result
-- ----------------------------
DROP TABLE IF EXISTS `up_pro_result`;
CREATE TABLE `up_pro_result` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `handle_user_name` varchar(100) DEFAULT NULL COMMENT '受理人员',
  `is_delivery_results` varchar(2) NOT NULL COMMENT '是否快递递送结果',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `result_cetr_name` longtext COMMENT '结果证照名称',
  `result_cetr_no` varchar(2000) DEFAULT NULL COMMENT '结果证照编号',
  `result_date` datetime NOT NULL COMMENT '办结时间',
  `result_explain` varchar(2000) DEFAULT NULL COMMENT '办件结果描述',
  `result_type` varchar(2) NOT NULL COMMENT '办结结果',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `satisfaction` varchar(2) DEFAULT NULL COMMENT '满意度',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
