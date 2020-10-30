/*
Navicat MySQL Data Transfer

Source Server         : mysql本地
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-10-30 09:25:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for up_task_general_material
-- ----------------------------
DROP TABLE IF EXISTS `up_task_general_material`;
CREATE TABLE `up_task_general_material` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `accept_stand` longtext COMMENT '受理标准',
  `by_law` longtext COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) DEFAULT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` longtext COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(36) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
