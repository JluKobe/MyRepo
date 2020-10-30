/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:21:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_lic_data_error
-- ----------------------------
DROP TABLE IF EXISTS `dn_lic_data_error`;
CREATE TABLE `dn_lic_data_error` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_area_code` varchar(32) NOT NULL COMMENT '证照所属管辖属地编码',
  `certificate_holder` longtext NOT NULL COMMENT '持证主体',
  `certificate_holder_code` longtext NOT NULL COMMENT '持证主体代码',
  `certificate_holder_type` varchar(2000) DEFAULT NULL COMMENT '持证主体代码类型',
  `certificate_name` varchar(512) NOT NULL COMMENT '证照名称',
  `certificate_number` varchar(128) NOT NULL COMMENT '证照编码',
  `certificate_source_id` varchar(128) NOT NULL COMMENT '电子证照源标识',
  `certificate_type` varchar(256) NOT NULL COMMENT '证照类型名称',
  `certificate_type_code` varchar(64) NOT NULL COMMENT '证照类型代码',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `error_remark` varchar(512) NOT NULL COMMENT '异常说明',
  `issue_date` varchar(32) NOT NULL COMMENT '证照颁发日期',
  `issue_dept` longtext NOT NULL COMMENT '证照颁发机构',
  `issue_dept_code` longtext NOT NULL COMMENT '证照颁发机构代码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
