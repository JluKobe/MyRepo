/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:23:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_uc_adult_abnormal
-- ----------------------------
DROP TABLE IF EXISTS `dn_uc_adult_abnormal`;
CREATE TABLE `dn_uc_adult_abnormal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `err_type` varchar(100) NOT NULL COMMENT '异常类型',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `table_cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `table_cd_source` varchar(10) NOT NULL COMMENT '数据来源',
  `table_cd_time` datetime NOT NULL COMMENT '上传日期',
  `table_name` varchar(50) NOT NULL COMMENT '数据表中文名',
  `table_row_guid` varchar(50) NOT NULL COMMENT '数据表主键',
  `table_sql_name` varchar(50) NOT NULL COMMENT '数据表英文名',
  `table_update_time` datetime NOT NULL COMMENT '进入汇聚区日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
