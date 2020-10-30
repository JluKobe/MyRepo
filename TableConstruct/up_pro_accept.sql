/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_pro_accept
-- ----------------------------
DROP TABLE IF EXISTS `up_pro_accept`;
CREATE TABLE `up_pro_accept` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `accept_date` datetime NOT NULL COMMENT '受理时间',
  `accept_doc_no` varchar(50) DEFAULT NULL COMMENT '受理文书编号',
  `address` varchar(1000) DEFAULT NULL COMMENT '通讯地址',
  `apply_date` datetime NOT NULL COMMENT '申请时间',
  `apply_type` varchar(2) NOT NULL COMMENT '申请类型',
  `applyer_name` varchar(100) NOT NULL COMMENT '申请人名称',
  `applyer_page_code` varchar(500) NOT NULL COMMENT '申请人证件号码',
  `applyer_page_type` varchar(70) NOT NULL COMMENT '申请人证件类型',
  `applyer_type` varchar(2) NOT NULL COMMENT '申请人类型',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `contact_code` varchar(50) DEFAULT NULL COMMENT '联系人/代理人证件号码',
  `contact_mobile` varchar(11) DEFAULT NULL COMMENT '联系人手机号码',
  `contact_name` varchar(100) DEFAULT NULL COMMENT '联系人/代理人姓名',
  `contact_type` varchar(6) DEFAULT NULL COMMENT '联系人/代理人证件类型',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `handle_user_name` varchar(100) DEFAULT NULL COMMENT '受理人员',
  `legal` varchar(100) DEFAULT NULL COMMENT '法定代表人',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `org_code` varchar(18) NOT NULL COMMENT '受理部门编码',
  `org_name` varchar(100) NOT NULL COMMENT '受理部门',
  `project_name` varchar(1000) DEFAULT NULL COMMENT '办理摘要',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `project_type` varchar(2) NOT NULL COMMENT '办理类型',
  `promise_date` datetime DEFAULT NULL COMMENT '承诺办结时间',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
