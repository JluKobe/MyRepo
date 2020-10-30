/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:26:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_corporator_identity
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_corporator_identity`;
CREATE TABLE `up_uc_corporator_identity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_key` varchar(128) NOT NULL COMMENT '法人机构代码散列值',
  `certificate_sno` varchar(128) DEFAULT NULL COMMENT '法人机构代码',
  `corp_name` varchar(128) DEFAULT NULL COMMENT '法人名称',
  `corp_status` varchar(6) DEFAULT NULL COMMENT '法人状态',
  `corp_type` varchar(64) DEFAULT NULL COMMENT '法人类型',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `legal_cert_type` varchar(12) DEFAULT NULL COMMENT '法定代表人证件类型',
  `legal_certno` varchar(64) DEFAULT NULL COMMENT '法定代表人证件号',
  `legal_certno_begin_date` varchar(12) DEFAULT NULL COMMENT '法定代表人证件有效期起始日期',
  `legal_certno_end_date` varchar(12) DEFAULT NULL COMMENT '法定代表人证件有效期到期日期',
  `legal_mobile` varchar(64) DEFAULT NULL COMMENT '法人代表人手机号',
  `legal_name` varchar(64) DEFAULT NULL COMMENT '法定代表人姓名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
