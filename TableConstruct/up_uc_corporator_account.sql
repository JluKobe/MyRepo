/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:26:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_corporator_account
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_corporator_account`;
CREATE TABLE `up_uc_corporator_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `acct_type` varchar(64) NOT NULL COMMENT '账号类型',
  `agent_cert` varchar(64) DEFAULT NULL COMMENT '经办人证件号码',
  `agent_cert_begin_date` varchar(12) DEFAULT NULL COMMENT '证件有效期起始日期',
  `agent_cert_end_date` varchar(12) DEFAULT NULL COMMENT '证件有效期到期日期',
  `agent_cert_key` varchar(64) DEFAULT NULL COMMENT '经办人证件散列值',
  `agent_cert_type` varchar(12) DEFAULT NULL COMMENT '经办人证件类型',
  `agent_channel` varchar(6) NOT NULL COMMENT '账号来源代码',
  `agent_eff_date` varchar(8) DEFAULT NULL COMMENT '有效起始日期',
  `agent_exp_date` varchar(8) DEFAULT NULL COMMENT '有效结束日期',
  `agent_mobile` varchar(64) DEFAULT NULL COMMENT '手机号',
  `agent_name` varchar(64) DEFAULT NULL COMMENT '姓名',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '相关法人标识',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `trust_acct_no` varchar(64) NOT NULL COMMENT '信任标识账号',
  `trust_acct_no_key` varchar(128) NOT NULL COMMENT '信任身份标识账号散列值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
