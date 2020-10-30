/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:22:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dn_task_general_extend
-- ----------------------------
DROP TABLE IF EXISTS `dn_task_general_extend`;
CREATE TABLE `dn_task_general_extend` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `corp_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `corp_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `extend_field` varchar(2000) DEFAULT NULL COMMENT '扩展字段',
  `handle_area` varchar(2) DEFAULT NULL COMMENT '通办范围',
  `is_entry_center` varchar(2) NOT NULL COMMENT '是否进驻政务大厅',
  `is_express` varchar(2) NOT NULL COMMENT '是否支持物流快递',
  `is_online` varchar(2) NOT NULL COMMENT '是否网办',
  `is_pay_online` varchar(2) NOT NULL COMMENT '是否支持网上支付',
  `is_schedule` varchar(2) DEFAULT NULL COMMENT '是否支持预约办理',
  `is_service_terminals` varchar(2) DEFAULT NULL COMMENT '是否支持终端办理',
  `limit_explain` longtext COMMENT '数量限制',
  `limit_scene_explain` varchar(1000) DEFAULT NULL COMMENT '办理现场办理原因说明',
  `online_handle_depth` varchar(20) DEFAULT NULL COMMENT '网上办理深度',
  `online_handle_url` longtext COMMENT '网办地址',
  `other_dept` varchar(200) DEFAULT NULL COMMENT '联办机构',
  `result_guid` varchar(256) DEFAULT NULL COMMENT '审批结果样本',
  `result_name` varchar(200) DEFAULT NULL COMMENT '审批结果名称',
  `result_type` varchar(30) NOT NULL COMMENT '审批结果类型',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `service_type` varchar(200) DEFAULT NULL COMMENT '中介服务',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(36) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `town_code` varchar(18) DEFAULT NULL COMMENT '乡镇街道代码',
  `town_name` varchar(200) DEFAULT NULL COMMENT '乡镇街道名称',
  `user_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `user_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `village_code` varchar(18) DEFAULT NULL COMMENT '村居社区代码',
  `village_name` varchar(200) DEFAULT NULL COMMENT '村居社区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
