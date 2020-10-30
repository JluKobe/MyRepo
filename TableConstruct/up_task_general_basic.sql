/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:24:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_task_general_basic
-- ----------------------------
DROP TABLE IF EXISTS `up_task_general_basic`;
CREATE TABLE `up_task_general_basic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `accept_condition` longtext NOT NULL COMMENT '受理条件',
  `anticipate_day` int(11) NOT NULL COMMENT '法定办结时限',
  `anticipate_explain` longtext COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) NOT NULL COMMENT '法定办结时限单位',
  `app_is_single_login` varchar(2) NOT NULL COMMENT '移动端是否对接单点登录',
  `by_law` longtext NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `fee_basis` longtext COMMENT '收费依据',
  `handle_flow` longtext NOT NULL COMMENT '办理流程',
  `handle_type` varchar(5) DEFAULT NULL COMMENT '办理形式',
  `is_fee` varchar(2) NOT NULL COMMENT '是否收费',
  `is_single_login` varchar(2) NOT NULL COMMENT '计算机端是否对接单点登录',
  `limit_scene_num` int(11) NOT NULL COMMENT '到办事现场次数',
  `link_addr` longtext COMMENT '计算机端在线办理跳转地址',
  `link_way` longtext NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `mobile_terminal_url` longtext COMMENT '移动端办理地址',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `project_type` varchar(2) NOT NULL COMMENT '办件类型',
  `promise_day` int(11) NOT NULL COMMENT '承诺办结时限',
  `promise_explain` longtext NOT NULL COMMENT '承诺办结时限说明',
  `promise_type` int(2) NOT NULL COMMENT '承诺办结时限单位',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `server_type` varchar(32) NOT NULL COMMENT '服务对象',
  `special_procedure` varchar(500) NOT NULL COMMENT '特别程序',
  `supervise_way` longtext NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `transact_addr` varchar(500) NOT NULL COMMENT '办理地点',
  `transact_time` varchar(500) NOT NULL COMMENT '办理时间',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
