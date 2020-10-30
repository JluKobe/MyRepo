/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:26:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_gov_region
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_gov_region`;
CREATE TABLE `up_uc_gov_region` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `city` varchar(20) DEFAULT NULL COMMENT '地市',
  `county` varchar(20) DEFAULT NULL COMMENT '县',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `nation` varchar(6) NOT NULL COMMENT '国家',
  `parent_region_code` varchar(64) NOT NULL COMMENT '上级行政区域代码',
  `province` varchar(20) NOT NULL COMMENT '省',
  `region_code` varchar(64) NOT NULL COMMENT '行政区域代码',
  `region_desc` varchar(512) DEFAULT NULL COMMENT '行政区域描述',
  `region_lvl` varchar(6) NOT NULL COMMENT '行政区域登记',
  `region_name` varchar(256) NOT NULL COMMENT '行政区域名称',
  `region_req` varchar(64) NOT NULL COMMENT '区域顺序',
  `region_status` varchar(6) NOT NULL COMMENT '区域状态',
  `town` varchar(20) DEFAULT NULL COMMENT '镇',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
