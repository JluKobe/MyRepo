/* *
* 政务服务事项基本目录
* */
DROP TABLE IF EXISTS `up_task_directory`;
CREATE TABLE `up_task_directory` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项基本目录';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 基本信息
* */
DROP TABLE IF EXISTS `up_task_general_basic`;
CREATE TABLE `up_task_general_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_condition` varchar(256) NOT NULL COMMENT '受理条件',
  `anticipate_day` int(11) NOT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) NOT NULL COMMENT '法定办结时限单位',
  `app_is_single_login` varchar(2) NOT NULL COMMENT '移动端是否对接单点登录',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `fee_basis` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `handle_type` varchar(5) DEFAULT NULL COMMENT '办理形式',
  `is_fee` varchar(2) NOT NULL COMMENT '是否收费',
  `is_single_login` varchar(2) NOT NULL COMMENT '计算机端是否对接单点登录',
  `limit_scene_num` int(11) NOT NULL COMMENT '到办事现场次数',
  `link_addr` varchar(256) DEFAULT NULL COMMENT '计算机端在线办理跳转地址',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `mobile_terminal_url` varchar(500) DEFAULT NULL COMMENT '移动端办理地址',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `project_type` varchar(2) NOT NULL COMMENT '办件类型',
  `promise_day` int(11) NOT NULL COMMENT '承诺办结时限',
  `promise_explain` varchar(256) DEFAULT NULL COMMENT '承诺办结时限说明',
  `promise_type` int(2) NOT NULL COMMENT '承诺办结时限单位',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `server_type` varchar(32) NOT NULL COMMENT '服务对象',
  `special_procedure` varchar(500) NOT NULL COMMENT '特别程序',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `transact_addr` varchar(500) NOT NULL COMMENT '办理地点',
  `transact_time` varchar(500) NOT NULL COMMENT '办理时间',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 基本信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 扩展信息
* */
DROP TABLE IF EXISTS `up_task_general_extend`;
CREATE TABLE `up_task_general_extend` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `corp_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `corp_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `extend_field` varchar(2000) DEFAULT NULL COMMENT '扩展字段',
  `handle_area` varchar(2) DEFAULT NULL COMMENT '通办范围',
  `is_entry_center` varchar(2) NOT NULL COMMENT '是否进驻政务大厅',
  `is_express` varchar(2) NOT NULL COMMENT '是否支持物流快递',
  `is_online` varchar(2) NOT NULL COMMENT '是否网办',
  `is_pay_online` varchar(2) NOT NULL COMMENT '是否支持网上支付',
  `is_schedule` varchar(2) DEFAULT NULL COMMENT '是否支持预约办理',
  `is_service_terminals` varchar(2) DEFAULT NULL COMMENT '是否支持终端办理',
  `limit_explain` varchar(256) DEFAULT NULL COMMENT '数量限制',
  `limit_scene_explain` varchar(1000) DEFAULT NULL COMMENT '办理现场办理原因说明',
  `online_handle_depth` varchar(20) DEFAULT NULL COMMENT '网上办理深度',
  `online_handle_url` varchar(256) DEFAULT NULL COMMENT '网办地址',
  `other_dept` varchar(200) DEFAULT NULL COMMENT '联办机构',
  `result_guid` varchar(256) DEFAULT NULL COMMENT '审批结果样本',
  `result_name` varchar(200) DEFAULT NULL COMMENT '审批结果名称',
  `result_type` varchar(30) NOT NULL COMMENT '审批结果类型',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `service_type` varchar(500) DEFAULT NULL COMMENT '中介服务',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `town_code` varchar(18) DEFAULT NULL COMMENT '乡镇街道代码',
  `town_name` varchar(200) DEFAULT NULL COMMENT '乡镇街道名称',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `user_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `user_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  `village_code` varchar(18) DEFAULT NULL COMMENT '村居社区代码',
  `village_name` varchar(200) DEFAULT NULL COMMENT '村居社区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 扩展信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 材料目录信息
* */
DROP TABLE IF EXISTS `up_task_general_material`;
CREATE TABLE `up_task_general_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 材料目录信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 收费项目信息
* */
DROP TABLE IF EXISTS `up_task_general_fee_project`;
CREATE TABLE `up_task_general_fee_project` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `desc_explain` varchar(256) DEFAULT NULL COMMENT '允许减免依据',
  `fee_name` varchar(200) NOT NULL COMMENT '收费项目名称',
  `fee_stand` varchar(256) NOT NULL COMMENT '收费标准',
  `is_desc` varchar(2) DEFAULT NULL COMMENT '是否允许减免',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 收费项目信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 常见问题解答
* */
DROP TABLE IF EXISTS `up_task_general_questions`;
CREATE TABLE `up_task_general_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 常见问题解答';


/* *
* 处罚类事项 基本信息
* */
DROP TABLE IF EXISTS `up_task_punish_basic`;
CREATE TABLE `up_task_punish_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) NOT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `punishment_method` varchar(3000) NOT NULL COMMENT '处罚的行为、种类、幅度',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(2) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处罚类事项 基本信息';


/* *
* 处罚类事项 常见问题解答
* */
DROP TABLE IF EXISTS `up_task_punish_questions`;
CREATE TABLE `up_task_punish_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处罚类事项 常见问题解答';


/* *
* 征收类事项 基本信息
* */
DROP TABLE IF EXISTS `up_task_handle_basic`;
CREATE TABLE `up_task_handle_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `collect_type` varchar(2) DEFAULT NULL COMMENT '征收种类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `is_permit_reduce` varchar(2) DEFAULT NULL COMMENT '是否涉及征收费减免的审批',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 基本信息';


/* *
* 征收类事项 材料目录信息
* */
DROP TABLE IF EXISTS `up_task_handle_material`;
CREATE TABLE `up_task_handle_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 材料目录信息';


/* *
* 征收类事项 常见问题解答
* */
DROP TABLE IF EXISTS `up_task_handle_questions`;
CREATE TABLE `up_task_handle_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 常见问题解答';


/* *
* 强制、检查类事项 基本信息
* */
DROP TABLE IF EXISTS `up_task_check_basic`;
CREATE TABLE `up_task_check_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='强制、检查类事项 基本信息';


/* *
* 强制、检查类事项 常见问题解答
* */
DROP TABLE IF EXISTS `up_task_check_questions`;
CREATE TABLE `up_task_check_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='强制、检查类事项 常见问题解答';


/* *
* 公共服务类事项 基本信息
* */
DROP TABLE IF EXISTS `up_task_public_basic`;
CREATE TABLE `up_task_public_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_condition` varchar(256) NOT NULL COMMENT '受理条件',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `app_is_single_login` varchar(2) NOT NULL COMMENT '移动端是否对接单点登录',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `fee_basis` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `handle_type` varchar(5) DEFAULT NULL COMMENT '办理形式',
  `is_fee` varchar(2) NOT NULL COMMENT '是否收费',
  `is_single_login` varchar(2) NOT NULL COMMENT '计算机端是否对接单点登录',
  `limit_scene_num` int(11) NOT NULL COMMENT '到办事现场次数',
  `link_addr` varchar(256) DEFAULT NULL COMMENT '计算机端在线办理跳转地址',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `mobile_terminal_url` varchar(500) DEFAULT NULL COMMENT '移动端办理地址',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `project_type` varchar(2) NOT NULL COMMENT '办件类型',
  `promise_day` int(11) DEFAULT NULL COMMENT '承诺办结时限',
  `promise_explain` varchar(256) DEFAULT NULL COMMENT '承诺办结时限说明',
  `promise_type` int(2) DEFAULT NULL COMMENT '承诺办结时限单位',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `server_type` varchar(32) NOT NULL COMMENT '服务对象',
  `special_procedure` varchar(500) NOT NULL COMMENT '特别程序',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `transact_addr` varchar(500) NOT NULL COMMENT '办理地点',
  `transact_time` varchar(500) NOT NULL COMMENT '办理时间',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 基本信息';


/* *
* 公共服务类事项 扩展信息
* */
DROP TABLE IF EXISTS `up_task_public_extend`;
CREATE TABLE `up_task_public_extend` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `corp_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `corp_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `extend_field` varchar(2000) DEFAULT NULL COMMENT '扩展字段',
  `handle_area` varchar(2) DEFAULT NULL COMMENT '通办范围',
  `is_entry_center` varchar(2) NOT NULL COMMENT '是否进驻政务大厅',
  `is_express` varchar(2) NOT NULL COMMENT '是否支持物流快递',
  `is_online` varchar(2) NOT NULL COMMENT '是否网办',
  `is_pay_online` varchar(2) NOT NULL COMMENT '是否支持网上支付',
  `is_schedule` varchar(2) DEFAULT NULL COMMENT '是否支持预约办理',
  `is_service_terminals` varchar(2) DEFAULT NULL COMMENT '是否支持终端办理',
  `limit_scene_explain` varchar(1000) DEFAULT NULL COMMENT '办理现场办理原因说明',
  `online_handle_depth` varchar(20) DEFAULT NULL COMMENT '网上办理深度',
  `online_handle_url` varchar(256) DEFAULT NULL COMMENT '网办地址',
  `other_dept` varchar(200) DEFAULT NULL COMMENT '联办机构',
  `result_guid` varchar(256) DEFAULT NULL COMMENT '审批结果样本',
  `result_name` varchar(200) DEFAULT NULL COMMENT '审批结果名称',
  `result_type` varchar(2) NOT NULL COMMENT '审批结果类型',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `service_type` varchar(500) DEFAULT NULL COMMENT '中介服务',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `town_code` varchar(18) DEFAULT NULL COMMENT '乡镇街道代码',
  `town_name` varchar(200) DEFAULT NULL COMMENT '乡镇街道名称',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `user_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `user_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  `village_code` varchar(18) DEFAULT NULL COMMENT '村居社区代码',
  `village_name` varchar(200) DEFAULT NULL COMMENT '村居社区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 扩展信息';


/* *
* 公共服务类事项 材料目录信息
* */
DROP TABLE IF EXISTS `up_task_public_material`;
CREATE TABLE `up_task_public_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 材料目录信息';


/* *
* 公共服务类事项 收费项目信息
* */
DROP TABLE IF EXISTS `up_task_public_fee_project`;
CREATE TABLE `up_task_public_fee_project` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `desc_explain` varchar(256) DEFAULT NULL COMMENT '允许减免依据',
  `fee_name` varchar(200) NOT NULL COMMENT '收费项目名称',
  `fee_stand` varchar(256) NOT NULL COMMENT '收费标准',
  `is_desc` varchar(2) DEFAULT NULL COMMENT '是否允许减免',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 收费项目信息';


/* *
* 公共服务类事项 常见问题解答
* */
DROP TABLE IF EXISTS `up_task_public_questions`;
CREATE TABLE `up_task_public_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 常见问题解答';


/* *
* 区域内实施 主体信息
* */
DROP TABLE IF EXISTS `up_zone_organization`;
CREATE TABLE `up_zone_organization` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `credit_code` varchar(18) NOT NULL COMMENT '统一社会信用代码',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `exist_task` varchar(2) NOT NULL COMMENT '部门是否存在并且行使政务服务事项',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `org_code` varchar(9) DEFAULT NULL COMMENT '组织机构代码',
  `org_name` varchar(100) NOT NULL COMMENT '部门名称',
  `org_short_name` varchar(50) NOT NULL COMMENT '部门简称',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='区域内实施 主体信息';


/* *
* 政务服务事项办件信息 办件受理信息
* */
DROP TABLE IF EXISTS `up_pro_accept`;
CREATE TABLE `up_pro_accept` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
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
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `handle_user_name` varchar(100) DEFAULT NULL COMMENT '受理人员',
  `legal` varchar(100) DEFAULT NULL COMMENT '法定代表人',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `org_code` varchar(64) NOT NULL COMMENT '受理部门编码',
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
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  `zip_code` varchar(6) DEFAULT NULL COMMENT '邮编',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项办件信息 办件受理信息';


/* *
* 政务服务事项办件信息 办件过程信息
* */
DROP TABLE IF EXISTS `up_pro_process`;
CREATE TABLE `up_pro_process` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `event_end_time` datetime NOT NULL COMMENT '环节结束时间',
  `event_name` varchar(2) NOT NULL COMMENT '业务动作',
  `event_start_time` datetime NOT NULL COMMENT '环节开始时间',
  `handle_explain` varchar(2000) NOT NULL COMMENT '办理意见',
  `handle_user_name` varchar(100) NOT NULL COMMENT '受理人员',
  `process_name` varchar(1000) NOT NULL COMMENT '办理环节名称',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项办件信息 办件过程信息';


/* *
* 政务服务事项办件信息 办件结果信息
* */
DROP TABLE IF EXISTS `up_pro_result`;
CREATE TABLE `up_pro_result` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `handle_user_name` varchar(100) DEFAULT NULL COMMENT '受理人员',
  `is_delivery_results` varchar(2) NOT NULL COMMENT '是否快递递送结果',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `result_cetr_name` varchar(256) DEFAULT NULL COMMENT '结果证照名称',
  `result_cetr_no` varchar(2000) DEFAULT NULL COMMENT '结果证照编号',
  `result_date` datetime NOT NULL COMMENT '办结时间',
  `result_explain` varchar(2000) DEFAULT NULL COMMENT '办件结果描述',
  `result_type` varchar(2) NOT NULL COMMENT '办结结果',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `satisfaction` varchar(2) DEFAULT NULL COMMENT '满意度',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项办件信息 办件结果信息';


/* *
* 政务服务事项办件信息 特别程序信息
* */
DROP TABLE IF EXISTS `up_pro_special_procedure`;
CREATE TABLE `up_pro_special_procedure` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `applyer_user_name` varchar(100) DEFAULT NULL COMMENT '申请人',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_time` datetime NOT NULL COMMENT '特别程序结束时间',
  `handle_user` varchar(100) DEFAULT NULL COMMENT '办理人',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `result` varchar(2000) DEFAULT NULL COMMENT '特别程序结果',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `special_explain` varchar(2000) DEFAULT NULL COMMENT '特别程序办理意见',
  `special_name` varchar(1000) NOT NULL COMMENT '特别程序种类名称',
  `special_reason` varchar(2000) NOT NULL COMMENT '特别程序启动理由或依据',
  `special_time` datetime NOT NULL COMMENT '特别程序开始时间',
  `special_type` varchar(2) NOT NULL COMMENT '特别程序种类',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项办件信息 特别程序信息';


/* *
* 政务服务事项办件信息 材料目录信息
* */
DROP TABLE IF EXISTS `up_pro_material`;
CREATE TABLE `up_pro_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `get_num` varchar(5) DEFAULT NULL COMMENT '收取数量',
  `get_type` varchar(2) NOT NULL COMMENT '收取方式',
  `material_attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `project_no` varchar(50) NOT NULL COMMENT '办件编号',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项办件信息 材料目录信息';


/* *
* 电子证照共享数据 证照目录信息
* */
DROP TABLE IF EXISTS `up_lic_data`;
CREATE TABLE `up_lic_data` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_area_code` varchar(32) NOT NULL COMMENT '证照所属管辖属地编码',
  `certificate_holder` varchar(256) NOT NULL COMMENT '持证主体',
  `certificate_holder_code` varchar(256) NOT NULL COMMENT '持证主体代码',
  `certificate_holder_type` varchar(2000) DEFAULT NULL COMMENT '持证主体代码类型',
  `certificate_name` varchar(512) NOT NULL COMMENT '证照名称',
  `certificate_number` varchar(128) NOT NULL COMMENT '证照编码',
  `certificate_source_id` varchar(128) NOT NULL COMMENT '电子证照源标识',
  `certificate_type` varchar(256) NOT NULL COMMENT '证照类型名称',
  `certificate_type_code` varchar(64) NOT NULL COMMENT '证照类型代码',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `issue_date` varchar(32) NOT NULL COMMENT '证照颁发日期',
  `issue_dept` varchar(256) NOT NULL COMMENT '证照颁发机构',
  `issue_dept_code` varchar(32) NOT NULL COMMENT '证照颁发机构代码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电子证照共享数据 证照目录信息';


/* *
* 用户信息数据 自然人信息资料表
* */
DROP TABLE IF EXISTS `up_uc_province_user`;
CREATE TABLE `up_uc_province_user` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `cert_eff_date` varchar(8) DEFAULT NULL COMMENT '证件有效日期',
  `cert_ext_date` varchar(8) DEFAULT NULL COMMENT '证件失效日期',
  `cert_key` varchar(128) NOT NULL COMMENT '证件散列码',
  `cert_no` varchar(64) DEFAULT NULL COMMENT '证件编号',
  `cert_type` varchar(6) DEFAULT NULL COMMENT '证件类型',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `user_alipay` varchar(64) DEFAULT NULL COMMENT '用户支付宝',
  `user_birthday` varchar(8) DEFAULT NULL COMMENT '用户生日',
  `user_edu` varchar(64) DEFAULT NULL COMMENT '用户学历',
  `user_home_address` varchar(128) DEFAULT NULL COMMENT '用户户籍地址',
  `user_life_address` varchar(128) DEFAULT NULL COMMENT '用户居住地址',
  `user_mail` varchar(64) DEFAULT NULL COMMENT '用户邮箱',
  `user_mobile` varchar(64) DEFAULT NULL COMMENT '用户手机号',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户名称',
  `user_real_lvl` varchar(64) NOT NULL COMMENT '用户实名等级',
  `user_region` varchar(6) NOT NULL COMMENT '用户来源区别',
  `user_sex` varchar(6) DEFAULT NULL COMMENT '用户性别',
  `user_ssi_location` varchar(128) DEFAULT NULL COMMENT '发卡地',
  `user_ssi_no` varchar(64) DEFAULT NULL COMMENT '社保卡号',
  `user_weixin` varchar(64) DEFAULT NULL COMMENT '用户微信',
  `user_work` varchar(128) DEFAULT NULL COMMENT '用户工作单位',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 自然人信息资料表';


/* *
* 用户信息数据 法人身份信息
* */
DROP TABLE IF EXISTS `up_uc_corporator_identity`;
CREATE TABLE `up_uc_corporator_identity` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_key` varchar(128) NOT NULL COMMENT '法人机构代码散列值',
  `certificate_sno` varchar(128) DEFAULT NULL COMMENT '法人机构代码',
  `corp_name` varchar(256) DEFAULT NULL COMMENT '法人名称',
  `corp_status` varchar(6) DEFAULT NULL COMMENT '法人状态',
  `corp_type` varchar(64) NOT NULL COMMENT '法人类型',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `legal_cert_no` varchar(64) DEFAULT NULL COMMENT '法定代表人证件号',
  `legal_cert_type` varchar(12) DEFAULT NULL COMMENT '法定代表人证件类型',
  `legal_certno_begin_date` varchar(12) DEFAULT NULL COMMENT '法定代表人证件有效期起始日期',
  `legal_certno_end_date` varchar(12) DEFAULT NULL COMMENT '法定代表人证件有效期到期日期',
  `legal_mobile` varchar(64) DEFAULT NULL COMMENT '法人代表人手机号',
  `legal_name` varchar(64) DEFAULT NULL COMMENT '法定代表人姓名',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 法人身份信息';


/* *
* 用户信息数据 法人账号信息
* */
DROP TABLE IF EXISTS `up_uc_corporator_account`;
CREATE TABLE `up_uc_corporator_account` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
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
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `trust_acct_no` varchar(64) NOT NULL COMMENT '信任标识账号',
  `trust_acct_no_key` varchar(128) NOT NULL COMMENT '信任身份标识账号散列值',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 法人账号信息';


/* *
* 用户信息数据 企业法人信息
* */
DROP TABLE IF EXISTS `up_uc_info_enterprise`;
CREATE TABLE `up_uc_info_enterprise` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '法人标识',
  `create_date` varchar(20) NOT NULL COMMENT '创建时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `enterprise_address` varchar(128) DEFAULT NULL COMMENT '企业机构注册地址',
  `enterprise_approval_date` varchar(20) DEFAULT NULL COMMENT '核准日期',
  `enterprise_approver_agency` varchar(64) DEFAULT NULL COMMENT '核准机构',
  `enterprise_begin_date` varchar(20) DEFAULT NULL COMMENT '营业限期起始',
  `enterprise_capital` varchar(12) DEFAULT NULL COMMENT '企业机构注册金额',
  `enterprise_end_date` varchar(20) DEFAULT NULL COMMENT '营业限期截止',
  `enterprise_industry` varchar(64) DEFAULT NULL COMMENT '行业类型',
  `enterprise_range` varchar(4000) DEFAULT NULL COMMENT '企业机构经营范围',
  `enterprise_register_date` varchar(20) DEFAULT NULL COMMENT '企业机构注册日期',
  `enterprise_small_class` varchar(64) DEFAULT NULL COMMENT '行业小类',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 企业法人信息';


/* *
* 用户信息数据 社会组织法人信息
* */
DROP TABLE IF EXISTS `up_uc_info_association`;
CREATE TABLE `up_uc_info_association` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
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
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_date` varchar(20) DEFAULT NULL COMMENT '证书有效期止',
  `fund_kind` varchar(6) DEFAULT NULL COMMENT '基金会类型',
  `industry` varchar(64) DEFAULT NULL COMMENT '所属行业',
  `reg_address` varchar(128) DEFAULT NULL COMMENT '住所',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '登记时间',
  `reg_money` varchar(12) DEFAULT NULL COMMENT '注册资金',
  `social_org_type` varchar(6) DEFAULT NULL COMMENT '社会组织类型',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 社会组织法人信息';


/* *
* 用户信息数据 事业单位法人信息
* */
DROP TABLE IF EXISTS `up_uc_info_central_dept`;
CREATE TABLE `up_uc_info_central_dept` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `begin_date` varchar(20) DEFAULT NULL COMMENT '期限起始',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_sno` varchar(64) NOT NULL COMMENT '法人标识',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `end_date` varchar(20) DEFAULT NULL COMMENT '期限结束',
  `fund_source` varchar(64) DEFAULT NULL COMMENT '经费来源',
  `reg_address` varchar(128) DEFAULT NULL COMMENT '注册地址',
  `reg_authority` varchar(128) DEFAULT NULL COMMENT '登记管理机关',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '注册时间',
  `reg_money` varchar(12) DEFAULT NULL COMMENT '开办资金',
  `reg_organizer` varchar(128) DEFAULT NULL COMMENT '举办单位',
  `reg_range` varchar(2000) DEFAULT NULL COMMENT '宗旨和业务范围',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 事业单位法人信息';


/* *
* 用户信息数据 组织结构
* */
DROP TABLE IF EXISTS `up_uc_gov_org`;
CREATE TABLE `up_uc_gov_org` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `oper_eff_date` varchar(20) DEFAULT NULL COMMENT '经营期限-起始',
  `oper_exp_date` varchar(20) DEFAULT NULL COMMENT '经营期限-结束',
  `org_cc_code` varchar(128) NOT NULL COMMENT '统一社会信用代码',
  `org_code` varchar(64) NOT NULL COMMENT '组织机构编码',
  `org_name` varchar(256) NOT NULL COMMENT '组织机构名称',
  `org_seq` int(11) NOT NULL COMMENT '组织顺序',
  `org_status` varchar(6) NOT NULL COMMENT '组织状态',
  `org_type` varchar(64) NOT NULL COMMENT '组织机构类型',
  `parent_org_code` varchar(64) DEFAULT NULL COMMENT '上级机构组织编码',
  `reg_address` varchar(64) DEFAULT NULL COMMENT '注册地址',
  `reg_date` varchar(8) DEFAULT NULL COMMENT '注册日期',
  `region_code` varchar(64) NOT NULL COMMENT '行政区域编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 组织结构';


/* *
* 用户信息数据 行政区域
* */
DROP TABLE IF EXISTS `up_uc_gov_region`;
CREATE TABLE `up_uc_gov_region` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `city` varchar(20) DEFAULT NULL COMMENT '地市',
  `county` varchar(20) DEFAULT NULL COMMENT '县',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `nation` varchar(20) NOT NULL COMMENT '国家',
  `parent_region_code` varchar(64) NOT NULL COMMENT '上级行政区域代码',
  `province` varchar(20) NOT NULL COMMENT '省',
  `region_code` varchar(64) NOT NULL COMMENT '行政区域代码',
  `region_desc` varchar(512) DEFAULT NULL COMMENT '行政区域描述',
  `region_lvl` varchar(6) NOT NULL COMMENT '行政区域登记',
  `region_name` varchar(256) NOT NULL COMMENT '行政区域名称',
  `region_req` varchar(64) NOT NULL COMMENT '区域顺序',
  `region_status` varchar(6) NOT NULL COMMENT '区域状态',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `town` varchar(20) DEFAULT NULL COMMENT '镇',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 行政区域';


/* *
* 用户信息数据 政务人员基础信息
* */
DROP TABLE IF EXISTS `up_uc_gov_staff`;
CREATE TABLE `up_uc_gov_staff` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `cert_key` varchar(128) NOT NULL COMMENT '行政人员唯一标识',
  `cert_no` varchar(64) DEFAULT NULL COMMENT '证件号码',
  `cert_type` varchar(6) DEFAULT NULL COMMENT '证件类型',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `is_real` varchar(6) NOT NULL COMMENT '实名状态',
  `login_no` varchar(64) DEFAULT NULL COMMENT '登录账号',
  `org_id` varchar(64) NOT NULL COMMENT '所在组织',
  `real_date` varchar(20) DEFAULT NULL COMMENT '实名日期',
  `real_lvl` varchar(64) NOT NULL COMMENT '实名等级',
  `reg_date` varchar(20) DEFAULT NULL COMMENT '注册日期',
  `region_id` varchar(64) NOT NULL COMMENT '所在区域',
  `staff_code` varchar(64) NOT NULL COMMENT '人员编号',
  `staff_creater` varchar(64) DEFAULT NULL COMMENT '创建用户',
  `staff_duty` varchar(64) DEFAULT NULL COMMENT '人员岗位',
  `staff_lvl` varchar(64) DEFAULT NULL COMMENT '人员级别',
  `staff_name` varchar(64) DEFAULT NULL COMMENT '人员名称',
  `staff_phone` varchar(64) DEFAULT NULL COMMENT '人员联系电话',
  `staff_status` varchar(6) NOT NULL COMMENT '人员状态',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息数据 政务人员基础信息';


/* *
* 政务服务事项 基本目录
* */
DROP TABLE IF EXISTS `dn_task_directory`;
CREATE TABLE `dn_task_directory` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='政务服务事项 基本目录';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 基本信息
* */
DROP TABLE IF EXISTS `dn_task_general_basic`;
CREATE TABLE `dn_task_general_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_condition` varchar(256) NOT NULL COMMENT '受理条件',
  `anticipate_day` int(11) NOT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) NOT NULL COMMENT '法定办结时限单位',
  `app_is_single_login` varchar(2) NOT NULL COMMENT '移动端是否对接单点登录',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `fee_basis` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `handle_type` varchar(5) DEFAULT NULL COMMENT '办理形式',
  `is_fee` varchar(2) NOT NULL COMMENT '是否收费',
  `is_single_login` varchar(2) NOT NULL COMMENT '计算机端是否对接单点登录',
  `limit_scene_num` int(11) NOT NULL COMMENT '到办事现场次数',
  `link_addr` varchar(256) DEFAULT NULL COMMENT '计算机端在线办理跳转地址',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `mobile_terminal_url` varchar(500) DEFAULT NULL COMMENT '移动端办理地址',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `project_type` varchar(2) NOT NULL COMMENT '办件类型',
  `promise_day` int(11) NOT NULL COMMENT '承诺办结时限',
  `promise_explain` varchar(256) DEFAULT NULL COMMENT '承诺办结时限说明',
  `promise_type` int(2) NOT NULL COMMENT '承诺办结时限单位',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `server_type` varchar(32) NOT NULL COMMENT '服务对象',
  `special_procedure` varchar(500) NOT NULL COMMENT '特别程序',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `transact_addr` varchar(500) NOT NULL COMMENT '办理地点',
  `transact_time` varchar(500) NOT NULL COMMENT '办理时间',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 基本信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 扩展信息
* */
DROP TABLE IF EXISTS `dn_task_general_extend`;
CREATE TABLE `dn_task_general_extend` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `corp_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `corp_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `extend_field` varchar(2000) DEFAULT NULL COMMENT '扩展字段',
  `handle_area` varchar(2) DEFAULT NULL COMMENT '通办范围',
  `is_entry_center` varchar(2) NOT NULL COMMENT '是否进驻政务大厅',
  `is_express` varchar(2) NOT NULL COMMENT '是否支持物流快递',
  `is_online` varchar(2) NOT NULL COMMENT '是否网办',
  `is_pay_online` varchar(2) NOT NULL COMMENT '是否支持网上支付',
  `is_schedule` varchar(2) DEFAULT NULL COMMENT '是否支持预约办理',
  `is_service_terminals` varchar(2) DEFAULT NULL COMMENT '是否支持终端办理',
  `limit_explain` varchar(256) DEFAULT NULL COMMENT '数量限制',
  `limit_scene_explain` varchar(1000) DEFAULT NULL COMMENT '办理现场办理原因说明',
  `online_handle_depth` varchar(20) DEFAULT NULL COMMENT '网上办理深度',
  `online_handle_url` varchar(256) DEFAULT NULL COMMENT '网办地址',
  `other_dept` varchar(200) DEFAULT NULL COMMENT '联办机构',
  `result_guid` varchar(256) DEFAULT NULL COMMENT '审批结果样本',
  `result_name` varchar(200) DEFAULT NULL COMMENT '审批结果名称',
  `result_type` varchar(30) NOT NULL COMMENT '审批结果类型',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `service_type` varchar(500) DEFAULT NULL COMMENT '中介服务',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `town_code` varchar(18) DEFAULT NULL COMMENT '乡镇街道代码',
  `town_name` varchar(200) DEFAULT NULL COMMENT '乡镇街道名称',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `user_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `user_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  `village_code` varchar(18) DEFAULT NULL COMMENT '村居社区代码',
  `village_name` varchar(200) DEFAULT NULL COMMENT '村居社区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 扩展信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 材料目录信息
* */
DROP TABLE IF EXISTS `dn_task_general_material`;
CREATE TABLE `dn_task_general_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 材料目录信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 收费项目信息
* */
DROP TABLE IF EXISTS `dn_task_general_fee_project`;
CREATE TABLE `dn_task_general_fee_project` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `desc_explain` varchar(256) DEFAULT NULL COMMENT '允许减免依据',
  `fee_name` varchar(200) NOT NULL COMMENT '收费项目名称',
  `fee_stand` varchar(256) NOT NULL COMMENT '收费标准',
  `is_desc` varchar(2) DEFAULT NULL COMMENT '是否允许减免',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 收费项目信息';


/* *
* 许可、给付、奖励、确认、裁决、其他类事项 常见问题解答
* */
DROP TABLE IF EXISTS `dn_task_general_questions`;
CREATE TABLE `dn_task_general_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='许可、给付、奖励、确认、裁决、其他类事项 常见问题解答';


/* *
* 处罚类事项 基本信息
* */
DROP TABLE IF EXISTS `dn_task_punish_basic`;
CREATE TABLE `dn_task_punish_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_data` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `punishment_method` varchar(3000) NOT NULL COMMENT '处罚的行为、种类、幅度',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(2) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处罚类事项 基本信息';


/* *
* 处罚类事项 常见问题解答
* */
DROP TABLE IF EXISTS `dn_task_punish_questions`;
CREATE TABLE `dn_task_punish_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='处罚类事项 常见问题解答';


/* *
* 征收类事项 基本信息
* */
DROP TABLE IF EXISTS `dn_task_handle_basic`;
CREATE TABLE `dn_task_handle_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `collect_type` varchar(2) DEFAULT NULL COMMENT '征收种类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `is_permit_reduce` varchar(2) DEFAULT NULL COMMENT '是否涉及征收费减免的审批',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 基本信息';


/* *
* 征收类事项 材料目录信息
* */
DROP TABLE IF EXISTS `dn_task_handle_material`;
CREATE TABLE `dn_task_handle_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 材料目录信息';


/* *
* 征收类事项 常见问题解答
* */
DROP TABLE IF EXISTS `dn_task_handle_questions`;
CREATE TABLE `dn_task_handle_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='征收类事项 常见问题解答';


/* *
* 强制、检查类事项 基本信息
* */
DROP TABLE IF EXISTS `dn_task_check_basic`;
CREATE TABLE `dn_task_check_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `power_source` varchar(2) NOT NULL COMMENT '权力来源',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='强制、检查类事项 基本信息';


/* *
* 强制、检查类事项 常见问题解答
* */
DROP TABLE IF EXISTS `dn_task_check_questions`;
CREATE TABLE `dn_task_check_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='强制、检查类事项 常见问题解答';


/* *
* 公共服务类事项 基本信息
* */
DROP TABLE IF EXISTS `dn_task_public_basic`;
CREATE TABLE `dn_task_public_basic` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_condition` varchar(256) NOT NULL COMMENT '受理条件',
  `anticipate_day` int(11) DEFAULT NULL COMMENT '法定办结时限',
  `anticipate_explain` varchar(256) DEFAULT NULL COMMENT '法定办结时限说明',
  `anticipate_type` varchar(2) DEFAULT NULL COMMENT '法定办结时限单位',
  `app_is_single_login` varchar(2) NOT NULL COMMENT '移动端是否对接单点登录',
  `by_law` varchar(256) NOT NULL COMMENT '设定依据',
  `catalog_code` varchar(12) NOT NULL COMMENT '基本编码',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `dept_code` varchar(50) NOT NULL COMMENT '实施主体编码',
  `dept_name` varchar(200) NOT NULL COMMENT '实施主体',
  `dept_type` varchar(2) NOT NULL COMMENT '实施主体性质',
  `entrust_name` varchar(100) DEFAULT NULL COMMENT '委托部门',
  `fee_basis` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `handle_flow` varchar(256) NOT NULL COMMENT '办理流程',
  `handle_type` varchar(5) DEFAULT NULL COMMENT '办理形式',
  `is_fee` varchar(2) NOT NULL COMMENT '是否收费',
  `is_single_login` varchar(2) NOT NULL COMMENT '计算机端是否对接单点登录',
  `limit_scene_num` int(11) NOT NULL COMMENT '到办事现场次数',
  `link_addr` varchar(256) DEFAULT NULL COMMENT '计算机端在线办理跳转地址',
  `link_way` varchar(256) NOT NULL COMMENT '咨询方式',
  `local_catalog_code` varchar(50) DEFAULT NULL COMMENT '地方基本编码',
  `local_task_code` varchar(50) DEFAULT NULL COMMENT '地方实施编码',
  `mobile_terminal_url` varchar(500) DEFAULT NULL COMMENT '移动端办理地址',
  `plan_cancel_date` datetime DEFAULT NULL COMMENT '计划取消日期',
  `plan_effective_date` datetime DEFAULT NULL COMMENT '计划生效日期',
  `project_type` varchar(2) NOT NULL COMMENT '办件类型',
  `promise_day` int(11) DEFAULT NULL COMMENT '承诺办结时限',
  `promise_explain` varchar(256) DEFAULT NULL COMMENT '承诺办结时限说明',
  `promise_type` int(2) DEFAULT NULL COMMENT '承诺办结时限单位',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `server_type` varchar(32) NOT NULL COMMENT '服务对象',
  `special_procedure` varchar(500) NOT NULL COMMENT '特别程序',
  `supervise_way` varchar(256) NOT NULL COMMENT '监督投诉方式',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `task_name` varchar(1000) NOT NULL COMMENT '事项名称',
  `task_state` varchar(2) NOT NULL COMMENT '事项状态',
  `task_type` varchar(2) NOT NULL COMMENT '事项类型',
  `task_version` int(10) NOT NULL COMMENT '事项版本',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `transact_addr` varchar(500) NOT NULL COMMENT '办理地点',
  `transact_time` varchar(500) NOT NULL COMMENT '办理时间',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `use_level` varchar(11) NOT NULL COMMENT '行使层级',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 基本信息';


/* *
* 公共服务类事项 扩展信息
* */
DROP TABLE IF EXISTS `dn_task_public_extend`;
CREATE TABLE `dn_task_public_extend` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `corp_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `corp_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `extend_field` varchar(2000) DEFAULT NULL COMMENT '扩展字段',
  `handle_area` varchar(2) DEFAULT NULL COMMENT '通办范围',
  `is_entry_center` varchar(2) NOT NULL COMMENT '是否进驻政务大厅',
  `is_express` varchar(2) NOT NULL COMMENT '是否支持物流快递',
  `is_online` varchar(2) NOT NULL COMMENT '是否网办',
  `is_pay_online` varchar(2) NOT NULL COMMENT '是否支持网上支付',
  `is_schedule` varchar(2) DEFAULT NULL COMMENT '是否支持预约办理',
  `is_service_terminals` varchar(2) DEFAULT NULL COMMENT '是否支持终端办理',
  `limit_scene_explain` varchar(1000) DEFAULT NULL COMMENT '办理现场办理原因说明',
  `online_handle_depth` varchar(20) DEFAULT NULL COMMENT '网上办理深度',
  `online_handle_url` varchar(256) DEFAULT NULL COMMENT '网办地址',
  `other_dept` varchar(200) DEFAULT NULL COMMENT '联办机构',
  `result_guid` varchar(256) DEFAULT NULL COMMENT '审批结果样本',
  `result_name` varchar(200) DEFAULT NULL COMMENT '审批结果名称',
  `result_type` varchar(30) NOT NULL COMMENT '审批结果类型',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `service_type` varchar(500) DEFAULT NULL COMMENT '中介服务',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `town_code` varchar(18) DEFAULT NULL COMMENT '乡镇街道代码',
  `town_name` varchar(200) DEFAULT NULL COMMENT '乡镇街道名称',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `user_character_topic_type` varchar(100) DEFAULT NULL COMMENT '面向自然人地方特色主题分类',
  `user_topic_type` varchar(40) DEFAULT NULL COMMENT '面向自然人事项主题分类',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  `village_code` varchar(18) DEFAULT NULL COMMENT '村居社区代码',
  `village_name` varchar(200) DEFAULT NULL COMMENT '村居社区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 扩展信息';


/* *
* 公共服务类事项 材料信息
* */
DROP TABLE IF EXISTS `dn_task_public_material`;
CREATE TABLE `dn_task_public_material` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `accept_stand` varchar(256) DEFAULT NULL COMMENT '受理标准',
  `by_law` varchar(256) DEFAULT NULL COMMENT '要求提供材料的依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `example_guid` varchar(256) DEFAULT NULL COMMENT '示例样表',
  `fill_explain` varchar(500) DEFAULT NULL COMMENT '填报须知',
  `form_guid` varchar(256) DEFAULT NULL COMMENT '空白表格',
  `is_need` varchar(2) NOT NULL COMMENT '材料必要性',
  `material_format` varchar(2) DEFAULT NULL COMMENT '材料形式',
  `material_name` varchar(200) NOT NULL COMMENT '材料名称',
  `material_type` varchar(2) DEFAULT NULL COMMENT '材料类型',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `page_format` varchar(200) DEFAULT NULL COMMENT '纸质材料规格',
  `page_num` int(11) DEFAULT NULL COMMENT '纸质材料份数',
  `remark` varchar(256) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `source_explain` varchar(500) DEFAULT NULL COMMENT '来源渠道说明',
  `source_type` varchar(2) DEFAULT NULL COMMENT '来源渠道',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 材料信息';


/* *
* 公共服务类事项 收费项目信息
* */
DROP TABLE IF EXISTS `dn_task_public_fee_project`;
CREATE TABLE `dn_task_public_fee_project` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `by_law` varchar(256) DEFAULT NULL COMMENT '收费依据',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `desc_explain` varchar(256) DEFAULT NULL COMMENT '允许减免依据',
  `fee_name` varchar(200) NOT NULL COMMENT '收费项目名称',
  `fee_stand` varchar(256) NOT NULL COMMENT '收费标准',
  `is_desc` varchar(2) DEFAULT NULL COMMENT '是否允许减免',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 收费项目信息';


/* *
* 公共服务类事项 常见问题解答
* */
DROP TABLE IF EXISTS `dn_task_public_questions`;
CREATE TABLE `dn_task_public_questions` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `answer` varchar(256) NOT NULL COMMENT '答案',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `order_num` int(11) NOT NULL COMMENT '排序',
  `question` varchar(1000) NOT NULL COMMENT '问题',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_code` varchar(36) NOT NULL COMMENT '实施编码',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `task_handle_item` varchar(50) DEFAULT NULL COMMENT '业务办理项编码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公共服务类事项 常见问题解答';


/* *
* 事项办件异常 数据表
* */
DROP TABLE IF EXISTS `dn_audit_abnormal`;
CREATE TABLE `dn_audit_abnormal` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
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
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='事项办件异常 数据表';


/* *
* 电子证照共享异常数据 目录信息
* */
DROP TABLE IF EXISTS `dn_lic_data_error`;
CREATE TABLE `dn_lic_data_error` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_batch` varchar(32) NOT NULL COMMENT '批次号',
  `cd_operation` varchar(2) NOT NULL COMMENT '同步类型',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `certificate_area_code` varchar(32) NOT NULL COMMENT '证照所属管辖属地编码',
  `certificate_holder` varchar(256) NOT NULL COMMENT '持证主体',
  `certificate_holder_code` varchar(256) NOT NULL COMMENT '持证主体代码',
  `certificate_holder_type` varchar(2000) DEFAULT NULL COMMENT '持证主体代码类型',
  `certificate_name` varchar(512) NOT NULL COMMENT '证照名称',
  `certificate_number` varchar(128) NOT NULL COMMENT '证照编码',
  `certificate_source_id` varchar(128) NOT NULL COMMENT '电子证照源标识',
  `certificate_type` varchar(256) NOT NULL COMMENT '证照类型名称',
  `certificate_type_code` varchar(64) NOT NULL COMMENT '证照类型代码',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `data_source` varchar(3) NOT NULL COMMENT '数据来源',
  `error_remark` varchar(512) NOT NULL COMMENT '异常说明',
  `issue_date` varchar(32) NOT NULL COMMENT '证照颁发日期',
  `issue_dept` varchar(256) NOT NULL COMMENT '证照颁发机构',
  `issue_dept_code` varchar(32) NOT NULL COMMENT '证照颁发机构代码',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='电子证照共享异常数据 目录信息';


/* *
* 用户信息 异常数据
* */
DROP TABLE IF EXISTS `dn_uc_adult_abnormal`;
CREATE TABLE `dn_uc_adult_abnormal` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `cd_time` datetime NOT NULL COMMENT '同步时间',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
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
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息 异常数据';


/* *
* 情形分组表
* */
DROP TABLE IF EXISTS `dn_audit_item_condition`;
CREATE TABLE `dn_audit_item_condition` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `area_code` varchar(20) NOT NULL COMMENT '区划',
  `bs` varchar(2) NOT NULL COMMENT '区分标识',
  `condition_desc` varchar(500) DEFAULT NULL COMMENT '情形描述',
  `condition_name` varchar(50) NOT NULL COMMENT '情形名称',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `order_num` int(11) NOT NULL COMMENT '情形排序',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `task_guid` varchar(50) NOT NULL COMMENT '事项唯一标识',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='情形分组表';


/* *
* 情形下材料详情表
* */
DROP TABLE IF EXISTS `dn_audit_material_condition`;
CREATE TABLE `dn_audit_material_condition` (
  `id` bigint(20) NOT NULL COMMENT '雪花算法生成的ID',
  `area_code` varchar(20) NOT NULL COMMENT '区划',
  `bs` varchar(2) NOT NULL COMMENT '区分标识',
  `condition_desc` varchar(500) DEFAULT NULL COMMENT '情形描述',
  `condition_guid` varchar(50) NOT NULL COMMENT '情形唯一标识',
  `create_org_id` bigint(20) NOT NULL COMMENT '创建机构ID',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `create_user_id` bigint(20) NOT NULL COMMENT '创建人ID',
  `material_guid` varchar(50) NOT NULL COMMENT '材料唯一标识',
  `row_guid` varchar(50) NOT NULL COMMENT '记录唯一标识',
  `tenant_id` bigint(20) NOT NULL COMMENT '租户ID',
  `update_org_id` bigint(20) NOT NULL COMMENT '更新机构ID',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  `update_user_id` bigint(20) NOT NULL COMMENT '更新人ID',
  `version` int(10) NOT NULL DEFAULT '1' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='情形下材料详情表';
