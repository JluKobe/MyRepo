/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:27:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_uc_info_association
-- ----------------------------
DROP TABLE IF EXISTS `up_uc_info_association`;
CREATE TABLE `up_uc_info_association` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `act_area` varchar(64) DEFAULT NULL COMMENT '活动地域',
  `association_content` varchar(2000) DEFAULT NULL COMMENT '业务范围',
  `association_owner` varchar(64) DEFAULT NULL COMMENT '法定代表人',
  `begin_date` varchar(20) DEFAULT NULL COMMENT '证书有效期始',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '法人标识',
  `charity_org` varchar(6) DEFAULT NULL COMMENT '是否慈善组织',
  `competent_org` varchar(320) DEFAULT NULL COMMENT '业务主管单位',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_date` varchar(20) DEFAULT NULL COMMENT '证书有效期止',
  `fund_kind` varchar(6) DEFAULT NULL COMMENT '基金会类型',
  `industry` varchar(64) DEFAULT NULL COMMENT '所属行业',
  `reg_address` varchar(128) DEFAULT NULL COMMENT '住所',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '登记时间',
  `reg_money` varchar(12) DEFAULT NULL COMMENT '注册资金',
  `social_org_type` varchar(6) DEFAULT NULL COMMENT '社会组织类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
