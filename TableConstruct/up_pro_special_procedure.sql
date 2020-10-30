/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_pro_special_procedure
-- ----------------------------
DROP TABLE IF EXISTS `up_pro_special_procedure`;
CREATE TABLE `up_pro_special_procedure` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `applyer_user_name` varchar(100) DEFAULT NULL COMMENT '申请人',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_time` datetime NOT NULL COMMENT '特别程序结束时间',
  `handle_user` varchar(100) DEFAULT NULL COMMENT '办理人',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `result` varchar(2000) DEFAULT NULL COMMENT '特别程序结果',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `special_explain` varchar(2000) DEFAULT NULL COMMENT '特别程序办理意见',
  `special_name` varchar(1000) NOT NULL COMMENT '特别程序种类名称',
  `special_reason` varchar(2000) NOT NULL COMMENT '特别程序启动理由或依据',
  `special_time` datetime NOT NULL COMMENT '特别程序开始时间',
  `special_type` varchar(2) NOT NULL COMMENT '特别程序种类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
