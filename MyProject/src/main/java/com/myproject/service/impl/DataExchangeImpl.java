package com.myproject.service.impl;

import com.myproject.bean.*;
import com.myproject.service.IDataExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataExchangeImpl implements IDataExchange {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @Override
    public boolean doBusiness(List<String> taskHandleItemList) {

        for(String taskHandleItem : taskHandleItemList) {
            //1 根据taskHandleItem查询clean_dn_task_general_extend
            CleanDnTaskGeneralExtend cleanDnTaskGeneralExtend = queryCleanExtend(taskHandleItem);
            String taskGuid = cleanDnTaskGeneralExtend.getTaskGuid();

            //2 根据得到的taskGuid查询clean_dn_task_general_basic
            CleanDnTaskGeneralBasic cleanDnTaskGeneralBasic = queryCleanBasic(taskGuid);

            //3 根据得到数据，在igt_task_basic新增数据，基本信息
            insertIgtTaskBasic(cleanDnTaskGeneralBasic, cleanDnTaskGeneralExtend);

            //4 根据得到数据，在igt_task_extend新增数据，扩展信息
            insertIgtTaskExtend(cleanDnTaskGeneralBasic, cleanDnTaskGeneralExtend);

            //taskGuid = "0116172b-7f77-aaa3-909f-06617e9604cd";  //测试数据
            //5 根据material_guid查询clean_dn_task_general_material
            List<CleanDnTaskGeneralMaterial> cleanDnTaskGeneralMaterialList = queryCleanMaterial(taskGuid);

            //6 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息
            insertIgtTaskMaterialCatalogTask(cleanDnTaskGeneralMaterialList);

            //7 根据taskGuid查询clean_dn_audit_item_condition
            List<CleanDnTaskAuditItemCondition> cleanDnTaskAuditItemConditionList = queryCleanItemCondition(taskGuid);

            //8 根据得到数据，在igt_task_condition新增数据，事项情形
            insertIgtTaskCondition(cleanDnTaskAuditItemConditionList);

            //9 根据condition_guid查询clean_dn_audit_material_condition
            List<String> conditionGuidList = new ArrayList<>();
            for(CleanDnTaskAuditItemCondition cleanDnTaskAuditItemCondition : cleanDnTaskAuditItemConditionList) {
                String conditionGuid = cleanDnTaskAuditItemCondition.getRowGuid();
                conditionGuidList.add(conditionGuid);
            }
            List<CleanDnAuditMaterialCondition> cleanDnAuditMaterialConditionList = queryMaterialCondition(conditionGuidList);

            if(cleanDnAuditMaterialConditionList.size() > 0) {
                //10 根据得到数据，在igt_task_condition_material新增数据，情形材料关系
                insertIgtTaskConditionMaterial(cleanDnAuditMaterialConditionList);

                //更新igt_task_material_catalog中的condition_guid字段
                updateIgtTaskMaterialCatalogCondition(taskGuid, cleanDnAuditMaterialConditionList);
            }

            //11 根据taskGuid查询clean_dn_task_general_fee_project  收费情况
            List<CleanDnTaskGeneralFeeProject> cleanDnTaskGeneralFeeProjectList = queryCleanFee(taskGuid);

            //12 根据得到数据，在igt_task_fee新增数据，事项收费情况
            insertIgtTaskFee(cleanDnTaskGeneralFeeProjectList);
        }

        return true;
    }

    @Override
    public boolean doBusiness2(String taskGuid) {
        List<CleanDnTaskAuditItemCondition> cleanDnTaskAuditItemConditionList = queryCleanItemCondition(taskGuid);
        System.out.println(cleanDnTaskAuditItemConditionList.size());

//        insertIgtTaskCondition(cleanDnTaskAuditItemConditionList);

        List<String> conditionGuidList = new ArrayList<>();
        for(CleanDnTaskAuditItemCondition cleanDnTaskAuditItemCondition : cleanDnTaskAuditItemConditionList) {
            String conditionGuid = cleanDnTaskAuditItemCondition.getRowGuid();
            conditionGuidList.add(conditionGuid);
        }

        List<CleanDnAuditMaterialCondition> cleanDnAuditMaterialConditionList = queryMaterialCondition(conditionGuidList);

//        insertIgtTaskConditionMaterial(cleanDnAuditMaterialConditionList);

        return true;
    }

    /**
     * 根据material_guid查询clean_dn_task_general_material
     * @param taskGuid
     * @return
     */
    public List<CleanDnTaskGeneralMaterial> queryCleanMaterial(String taskGuid) {
        String sql = "select id, taskguid, rowguid, materialname, pagenum, pageformat, materialtype, materialformat, formguid, exampleguid, isneed, " +
                "sourcetype, sourceexplain, fillexplain, bylaw, acceptstand from task_test.clean_dn_task_general_material " +
                "where taskguid = ?";
        RowMapper<CleanDnTaskGeneralMaterial> rowMapper = new BeanPropertyRowMapper<>(CleanDnTaskGeneralMaterial.class);
        List<CleanDnTaskGeneralMaterial> cleanDnTaskGeneralMaterialList = jdbcTemplateOne.query(sql, rowMapper, taskGuid);
        return cleanDnTaskGeneralMaterialList;
    }

    /**
     * 根据taskHandleItem查询clean_dn_task_general_extend
     * @param taskHandleItem
     * @return
     */
    public CleanDnTaskGeneralExtend queryCleanExtend(String taskHandleItem) {
        String sql = "select * from task_test.clean_dn_task_general_extend where taskhandleitem = ?";
        RowMapper<CleanDnTaskGeneralExtend> rowMapper = new BeanPropertyRowMapper<>(CleanDnTaskGeneralExtend.class);
        return jdbcTemplateOne.queryForObject(sql, rowMapper, taskHandleItem);
    }

    /**
     * 根据得到的taskGuid查询clean_dn_task_general_basic
     * @param taskGuid
     * @return
     */
    public CleanDnTaskGeneralBasic queryCleanBasic(String taskGuid) {
        String sql = "select * from task_test.clean_dn_task_general_basic where rowguid = ?";
        RowMapper<CleanDnTaskGeneralBasic> rowMapper = new BeanPropertyRowMapper<>(CleanDnTaskGeneralBasic.class);
        return jdbcTemplateOne.queryForObject(sql, rowMapper, taskGuid);
    }

    /**
     * 根据taskGuid查询clean_dn_audit_item_condition
     * @param taskGuid
     * @return
     */
    public List<CleanDnTaskAuditItemCondition> queryCleanItemCondition(String taskGuid) {
        String sql = "select id, RowGuid, TaskGuid, Condition_Name, CONDITION_DESC from task_test.clean_dn_audit_item_condition where taskguid = ?";
        RowMapper<CleanDnTaskAuditItemCondition> rowMapper = new BeanPropertyRowMapper<>(CleanDnTaskAuditItemCondition.class);
        List<CleanDnTaskAuditItemCondition> cleanDnTaskAuditItemConditionList = jdbcTemplateOne.query(sql, rowMapper, taskGuid);
        return cleanDnTaskAuditItemConditionList;
    }

    /**
     * 根据taskGuid查询clean_dn_task_general_fee_project
     * @param taskGuid
     * @return
     */
    public List<CleanDnTaskGeneralFeeProject> queryCleanFee(String taskGuid) {
        String sql = "select id, feestand, feename, isdesc, descexplain, taskguid from task_test.clean_dn_task_general_fee_project where taskguid = ?";
        RowMapper<CleanDnTaskGeneralFeeProject> rowMapper = new BeanPropertyRowMapper<>(CleanDnTaskGeneralFeeProject.class);
        List<CleanDnTaskGeneralFeeProject> list = jdbcTemplateOne.query(sql, rowMapper, taskGuid);
        return list;
    }

    /**
     * 根据condition_guid查询clean_dn_audit_material_conditionjik
     * @param conditionList
     * @return
     */
    public List<CleanDnAuditMaterialCondition> queryMaterialCondition(List<String> conditionList) {
        List<CleanDnAuditMaterialCondition> cleanDnAuditMaterialConditionList = new ArrayList<>();
        String sql = "select id, condition_guid, MATERIAL_GUID from task_test.clean_dn_audit_material_condition where condition_guid = ?";
        RowMapper<CleanDnAuditMaterialCondition> rowMapper = new BeanPropertyRowMapper<>(CleanDnAuditMaterialCondition.class);
        for(String conditionGuid : conditionList) {
            List<CleanDnAuditMaterialCondition> list = jdbcTemplateOne.query(sql, rowMapper, conditionGuid);
            cleanDnAuditMaterialConditionList.addAll(list);
        }

        return cleanDnAuditMaterialConditionList;
    }

    /**
     * 根据得到数据，在igt_task_basic新增数据
     * @param cleanDnTaskGeneralBasic
     * @param cleanDnTaskGeneralExtend
     */
    public void insertIgtTaskBasic(CleanDnTaskGeneralBasic cleanDnTaskGeneralBasic, CleanDnTaskGeneralExtend cleanDnTaskGeneralExtend) {
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, Integer.valueOf(cleanDnTaskGeneralBasic.getId()));
                preparedStatement.setString(2, cleanDnTaskGeneralBasic.getCatalogCode());
                preparedStatement.setString(3, null);
                preparedStatement.setInt(4, 1);
                preparedStatement.setInt(5, 1);
                preparedStatement.setString(6, cleanDnTaskGeneralBasic.getDeptCode());
                preparedStatement.setString(7, cleanDnTaskGeneralBasic.getDeptName());
                preparedStatement.setString(8, cleanDnTaskGeneralBasic.getDeptType());
                preparedStatement.setString(9, cleanDnTaskGeneralBasic.getHandleType());
                preparedStatement.setString(10, "0");
                preparedStatement.setString(11, cleanDnTaskGeneralExtend.getIsEntryCenter());
                preparedStatement.setString(12, cleanDnTaskGeneralExtend.getIsExpress());
                preparedStatement.setString(13, cleanDnTaskGeneralExtend.getIsOnline());
                preparedStatement.setString(14, cleanDnTaskGeneralExtend.getIsPayOnline());
                preparedStatement.setString(15, cleanDnTaskGeneralExtend.getIsSchedule());
                preparedStatement.setString(16, cleanDnTaskGeneralExtend.getIsServiceTerminals());
                preparedStatement.setString(17, cleanDnTaskGeneralExtend.getIsEntryCenter());
                preparedStatement.setString(18, cleanDnTaskGeneralBasic.getLinkWay());
                preparedStatement.setString(19, cleanDnTaskGeneralBasic.getLocalCatalogCode());
                preparedStatement.setString(20, cleanDnTaskGeneralBasic.getLocalTaskCode());
                preparedStatement.setString(21, cleanDnTaskGeneralBasic.getPowerSource());
                preparedStatement.setString(22, cleanDnTaskGeneralBasic.getProjectType());
                preparedStatement.setString(23, cleanDnTaskGeneralBasic.getPromiseDay());
                preparedStatement.setString(24, cleanDnTaskGeneralExtend.getResultType());
                preparedStatement.setString(25, cleanDnTaskGeneralBasic.getServerType());
                preparedStatement.setString(26, cleanDnTaskGeneralBasic.getTaskCode());
                preparedStatement.setString(27, cleanDnTaskGeneralExtend.getTaskGuid());
                preparedStatement.setString(28, cleanDnTaskGeneralBasic.getTaskHandleItem());
                preparedStatement.setString(29, cleanDnTaskGeneralBasic.getTaskName());
                preparedStatement.setString(30, cleanDnTaskGeneralBasic.getTaskState());
                preparedStatement.setString(31, cleanDnTaskGeneralBasic.getTaskType());
                preparedStatement.setString(32, cleanDnTaskGeneralBasic.getTaskVersion());
                preparedStatement.setString(33, cleanDnTaskGeneralBasic.getTransactAddr());
                preparedStatement.setString(34, cleanDnTaskGeneralBasic.getTransactTime());
                preparedStatement.setInt(35, 1);
                preparedStatement.setInt(36, 1);
                preparedStatement.setString(37, cleanDnTaskGeneralBasic.getUseLevel());
                preparedStatement.setInt(38, 1);
            }
        };

        String sql = "insert into task.igt_task_basic (id, catalog_code, catalog_name, create_org_id, create_time," +
                "create_user_id, dept_code, dept_name, dept_type, handle_type, is_batch, is_entry_center, is_express, is_online," +
                "is_pay_online, is_schedule, is_service_terminals, is_window, link_way, local_catalog_code, local_task_code, " +
                "power_source, project_type, promise_day, result_group_code, server_type, task_code, task_guid, task_handle_item," +
                "task_name, task_state, task_type, task_version, transact_addr, transact_time, update_org_id, update_time, update_user_id," +
                "use_level, version) values(?,?,?,?,sysdate(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate(),?,?,?)";

        jdbcTemplateOne.update(sql, preparedStatementSetter);
    }

    /**
     * 根据得到数据，在igt_task_extend新增数据
     * @param cleanDnTaskGeneralBasic
     * @param cleanDnTaskGeneralExtend
     */
    public void insertIgtTaskExtend(CleanDnTaskGeneralBasic cleanDnTaskGeneralBasic, CleanDnTaskGeneralExtend cleanDnTaskGeneralExtend) {
        PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setInt(1, Integer.valueOf(cleanDnTaskGeneralExtend.getId()));
                preparedStatement.setString(2, cleanDnTaskGeneralBasic.getAcceptCondition());
                preparedStatement.setString(3, cleanDnTaskGeneralBasic.getAnticipateDay());
                preparedStatement.setString(4,  cleanDnTaskGeneralBasic.getAnticipateExplain());
                preparedStatement.setString(5, cleanDnTaskGeneralBasic.getAnticipateType());
                preparedStatement.setString(6, cleanDnTaskGeneralBasic.getAppIsSingleLogin());
                preparedStatement.setString(7, cleanDnTaskGeneralBasic.getByLaw());
                preparedStatement.setString(8, null);
                preparedStatement.setInt(9, 1);
                preparedStatement.setInt(10, 1);
                preparedStatement.setString(11, cleanDnTaskGeneralBasic.getEntrustName());
                preparedStatement.setString(12, cleanDnTaskGeneralExtend.getHandleArea());
                preparedStatement.setString(13, cleanDnTaskGeneralBasic.getHandleFlow());
                preparedStatement.setString(14, cleanDnTaskGeneralBasic.getIsSingleLogin());
                preparedStatement.setString(15, cleanDnTaskGeneralExtend.getLimitExplain());
                preparedStatement.setString(16, cleanDnTaskGeneralBasic.getLimitSceneNum());
                preparedStatement.setString(17, cleanDnTaskGeneralBasic.getLinkAddr());
                preparedStatement.setString(18, cleanDnTaskGeneralBasic.getMobileTerminalUrl());
                preparedStatement.setString(19, cleanDnTaskGeneralExtend.getOnlineHandleDepth());
                preparedStatement.setString(20, cleanDnTaskGeneralExtend.getOnlineHandleUrl());
                preparedStatement.setString(21, cleanDnTaskGeneralExtend.getOtherDept());
                preparedStatement.setString(22, cleanDnTaskGeneralBasic.getPlanCancelDate());
                preparedStatement.setString(23, cleanDnTaskGeneralBasic.getPlanEffectiveDate());
                preparedStatement.setString(24, cleanDnTaskGeneralBasic.getPromiseExplain());
                preparedStatement.setString(25, cleanDnTaskGeneralBasic.getPromiseType());
                preparedStatement.setString(26, cleanDnTaskGeneralExtend.getResultName());
                preparedStatement.setString(27, null);
                preparedStatement.setString(28, null);
                preparedStatement.setString(29, cleanDnTaskGeneralBasic.getServerType());
                preparedStatement.setString(30, cleanDnTaskGeneralBasic.getSpecialProcedure());
                preparedStatement.setString(31, cleanDnTaskGeneralBasic.getSuperviseWay());
                preparedStatement.setString(32, cleanDnTaskGeneralExtend.getTaskGuid());
                preparedStatement.setInt(33, 1);
                preparedStatement.setInt(34, 1);
                preparedStatement.setInt(35, 1);
            }
        };

        String sql = "insert into task.igt_task_extend (id, accept_condition, anticipate_day, anticipate_explain, anticipate_type," +
                "app_is_single_login, by_law, by_suppose, create_org_id, create_time, create_user_id, entrust_name, handle_area, " +
                "handle_flow, is_single_login, limit_scene_explain, limit_scene_num, link_addr, mobile_terminal_url, online_handle_depth, " +
                "online_handle_url, other_dept, plan_cancel_date, plan_effective_date, promise_explain, promise_type, result_name, " +
                "result_sample, result_type, service_type, special_procedure, supervise_way, task_guid, update_org_id, update_time, " +
                "update_user_id, version) values(?,?,?,?,?,?,?,?,?,sysdate(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate(),?,?)";

        jdbcTemplateOne.update(sql, preparedStatementSetter);
    }

    /**
     * 根据得到数据，在igt_task_fee新增数据
     * @param cleanDnTaskGeneralFeeProjectList
     */
    public void insertIgtTaskFee(List<CleanDnTaskGeneralFeeProject> cleanDnTaskGeneralFeeProjectList) {
        String sql = "insert into task.igt_task_fee (id, create_org_id, create_time, create_user_id, desc_explain, fee_name," +
                "fee_stand, is_desc, task_guid, update_org_id, update_time, update_user_id, version) values (?, ?, sysdate(), ?, ?, ?, ?, ?, ?, ?, sysdate(), ?, ?)";
        for(CleanDnTaskGeneralFeeProject cleanDnTaskGeneralFeeProject : cleanDnTaskGeneralFeeProjectList) {
            PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, Integer.valueOf(cleanDnTaskGeneralFeeProject.getId()));
                    preparedStatement.setInt(2, 1);
                    preparedStatement.setInt(3, 1);
                    preparedStatement.setString(4, cleanDnTaskGeneralFeeProject.getDescExplain());
                    preparedStatement.setString(5, cleanDnTaskGeneralFeeProject.getFeeName());
                    preparedStatement.setString(6, cleanDnTaskGeneralFeeProject.getFeeStand());
                    preparedStatement.setString(7, cleanDnTaskGeneralFeeProject.getIsDesc());
                    preparedStatement.setString(8, cleanDnTaskGeneralFeeProject.getTaskGuid());
                    preparedStatement.setInt(9, 1);
                    preparedStatement.setInt(10, 1);
                    preparedStatement.setInt(11, 1);
                }
            };

            jdbcTemplateOne.update(sql, preparedStatementSetter);
        }
    }

    /**
     * 根据得到数据，在igt_task_condition新增数据
     * @param cleanDnTaskAuditItemConditionList
     */
    public void insertIgtTaskCondition(List<CleanDnTaskAuditItemCondition> cleanDnTaskAuditItemConditionList) {
        String sql = "insert into task.igt_task_condition (id, condition_desc, condition_guid, condition_name, create_org_id, create_time, create_user_id, task_guid, update_org_id," +
                "update_time, update_user_id, version) values(?, ?, ?, ?, ?, sysdate(), ?, ?, ?, sysdate(), ?, ?)";
        for(CleanDnTaskAuditItemCondition cleanDnTaskAuditItemCondition : cleanDnTaskAuditItemConditionList) {
            PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, Integer.valueOf(cleanDnTaskAuditItemCondition.getId()));
                    preparedStatement.setString(2, cleanDnTaskAuditItemCondition.getConditionDesc());
                    preparedStatement.setString(3, cleanDnTaskAuditItemCondition.getRowGuid());
                    preparedStatement.setString(4, cleanDnTaskAuditItemCondition.getConditionName());
                    preparedStatement.setInt(5, 1);
                    preparedStatement.setInt(6, 1);
                    preparedStatement.setString(7, cleanDnTaskAuditItemCondition.getTaskGuid());
                    preparedStatement.setInt(8, 1);
                    preparedStatement.setInt(9, 1);
                    preparedStatement.setInt(10, 1);
                }
            };

            jdbcTemplateOne.update(sql, preparedStatementSetter);
        }
    }

    /**
     * 根据得到数据，在igt_task_condition_material新增数据
     * @param cleanDnAuditMaterialConditionList
     */
    public void insertIgtTaskConditionMaterial(List<CleanDnAuditMaterialCondition> cleanDnAuditMaterialConditionList) {
        String sql = "insert into task.igt_task_condition_material(id, condition_guid, create_org_id, create_time, create_user_id," +
                "material_guid, update_org_id, update_time, update_user_id, version) values(?, ?, ?, SYSDATE(), ?, ?, ?, SYSDATE(), ?, ?)";
        for(CleanDnAuditMaterialCondition cleanDnAuditMaterialCondition : cleanDnAuditMaterialConditionList) {
            PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, Integer.valueOf(cleanDnAuditMaterialCondition.getId()));
                    preparedStatement.setString(2, cleanDnAuditMaterialCondition.getConditionGuid());
                    preparedStatement.setInt(3, 1);
                    preparedStatement.setInt(4, 1);
                    preparedStatement.setString(5, cleanDnAuditMaterialCondition.getMaterialGuid());
                    preparedStatement.setInt(6, 1);
                    preparedStatement.setInt(7, 1);
                    preparedStatement.setInt(8, 1);
                }
            };

            jdbcTemplateOne.update(sql, preparedStatementSetter);
        }
    }

    /**
     * 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息
     * @param cleanDnTaskGeneralMaterialList
     */
    public void insertIgtTaskMaterialCatalogTask(List<CleanDnTaskGeneralMaterial> cleanDnTaskGeneralMaterialList) {
        String sql = "insert into task.igt_task_material_catalog (id, task_guid, material_guid, condition_guid, " +
                "material_name, page_num, page_format, material_type, material_format, form_guid, example_guid," +
                "is_need, is_reused, source_type, source_explain, fill_explain, by_law, accept_stand," +
                "create_org_id, create_time, create_user_id, update_org_id, update_time, update_user_id)" +
                "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '1', SYSDATE(), '1', '1', SYSDATE(), '1')";
        for(CleanDnTaskGeneralMaterial cleanDnTaskGeneralMaterial : cleanDnTaskGeneralMaterialList) {
            PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setInt(1, Integer.valueOf(cleanDnTaskGeneralMaterial.getId()));
                    preparedStatement.setString(2, cleanDnTaskGeneralMaterial.getTaskGuid());
                    preparedStatement.setString(3, cleanDnTaskGeneralMaterial.getRowGuid());
                    preparedStatement.setString(4, null);
                    preparedStatement.setString(5, cleanDnTaskGeneralMaterial.getMaterialName());
                    preparedStatement.setString(6, cleanDnTaskGeneralMaterial.getPageNum());
                    preparedStatement.setString(7, cleanDnTaskGeneralMaterial.getPageFormat());
                    preparedStatement.setString(8, cleanDnTaskGeneralMaterial.getMaterialType());
                    preparedStatement.setString(9, cleanDnTaskGeneralMaterial.getMaterialFormat());
                    preparedStatement.setString(10, cleanDnTaskGeneralMaterial.getFormGuid());
                    preparedStatement.setString(11, cleanDnTaskGeneralMaterial.getExampleGuid());
                    preparedStatement.setString(12, cleanDnTaskGeneralMaterial.getIsNeed());
                    preparedStatement.setString(13, "0");
                    preparedStatement.setString(14, cleanDnTaskGeneralMaterial.getSourceType());
                    preparedStatement.setString(15, cleanDnTaskGeneralMaterial.getSourceExplain());
                    preparedStatement.setString(16, cleanDnTaskGeneralMaterial.getFillExplain());
                    preparedStatement.setString(17, cleanDnTaskGeneralMaterial.getByLaw());
                    preparedStatement.setString(18, cleanDnTaskGeneralMaterial.getAcceptStand());
                }
            };
            jdbcTemplateOne.update(sql, preparedStatementSetter);
        }
    }

    /**
     * 更新igt_task_material_catalog中的condition_guid字段
     */
    public void updateIgtTaskMaterialCatalogCondition(String taskGuid, List<CleanDnAuditMaterialCondition> cleanDnAuditMaterialConditionList) {
        String sql = "update task.igt_task_material_catalog set condition_guid = ? where task_guid = ? and material_guid = ?";
        for(CleanDnAuditMaterialCondition cleanDnAuditMaterialCondition : cleanDnAuditMaterialConditionList) {
            PreparedStatementSetter preparedStatementSetter = new PreparedStatementSetter() {
                @Override
                public void setValues(PreparedStatement preparedStatement) throws SQLException {
                    preparedStatement.setString(1, cleanDnAuditMaterialCondition.getConditionGuid());
                    preparedStatement.setString(2, taskGuid);
                    preparedStatement.setString(3, cleanDnAuditMaterialCondition.getMaterialGuid());
                }
            };

            jdbcTemplateOne.update(sql, preparedStatementSetter);
        }
    }
}
