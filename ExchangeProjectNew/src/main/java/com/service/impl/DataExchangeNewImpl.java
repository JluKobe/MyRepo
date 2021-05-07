package com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.*;
import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.config.DbContextHolder;
import com.enums.DBTypeEnum;
import com.repository.*;
import com.service.IDataExchange;
import com.service.IDateExchangeNew;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 准生产环境，数据导入 igt_task_v1 新表
 */
@Service
@Slf4j
public class DataExchangeNewImpl implements IDateExchangeNew {

    @Autowired
    private CleanBasicRepository cleanBasicRepository;

    @Autowired
    private CleanExtendRepository cleanExtendRepository;

    @Autowired
    private CleanFeeProjectRepository cleanFeeProjectRepository;

    @Autowired
    private CleanMaterialRepository cleanMaterialRepository;

    @Autowired
    private CleanItemConditionRepository cleanItemConditionRepository;

    @Autowired
    private CleanDirectoryRepository cleanDirectoryRepository;

    @Autowired
    private CleanMaterialConditionRepository cleanMaterialConditionRepository;

    @Autowired
    private CleanQuestionsRepository cleanQuestionsRepository;

    @Autowired
    private CleanPublicExtendRepository cleanPublicExtendRepository;

    @Autowired
    private CleanPublicBasicRepository cleanPublicBasicRepository;

    @Autowired
    private CleanPublicMaterialRepository cleanPublicMaterialRepository;

    @Autowired
    private CleanPublicFeeRepository cleanPublicFeeRepository;

    @Autowired
    private CleanPublicQuestionRepository cleanPublicQuestionRepository;

    @Autowired
    private IgtBasicRepository igtBasicRepository;

    @Autowired
    private IgtExtendRepository igtExtendRepository;

    @Autowired
    private IgtMaterialRepository igtMaterialRepository;

    @Autowired
    private IgtConditionRepository igtConditionRepository;

    @Autowired
    private IgtConditionMaterialRepository igtConditionMaterialRepository;

    @Autowired
    private IgtFeeRepository igtFeeRepository;

    @Autowired
    private IgtQuestionRepository igtQuestionRepository;

    @Autowired
    SnowflakeManager snowflakeManager;

    /**
     * 准生产环境，数据导入 igt_task_v1 新表
     * @param vo
     * @return
     */

    @Override
    public ExchangeTaskHandleItemResponse doBusiness(ExchangeTaskHandleItemVo vo) {
        List<String> taskHandleItemList = vo.getTaskHandleItemList();

        log.info("数据导入 start，taskHandleItemList size : {}, 是否高频事项 : {}, 是否批量 : {}",
                taskHandleItemList.size(), vo.getIsHighFrequency(), vo.getIsBatch());
        long start = System.currentTimeMillis();
        List<String> taskGuidList = new ArrayList<>();

        //使用db2
        DbContextHolder.setDbType(DBTypeEnum.DB2);

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("taskhandleitem", taskHandleItemList);

        //查询 cleanBasic
        List<CleanBasic> cleanBasicList = cleanBasicRepository.selectList(wrapper);

        //查询 cleanExtend
        List<CleanExtend> cleanExtendList = cleanExtendRepository.selectList(wrapper);

        //查询 cleanQuestion
        List<CleanQuestions> cleanQuestionsList = cleanQuestionsRepository.selectList(wrapper);

        //查询 cleanFee
        List<CleanFeeProject> cleanFeeProjectList = cleanFeeProjectRepository.selectList(wrapper);

        //查询 cleanMaterial
        List<CleanMaterial> cleanMaterialList = cleanMaterialRepository.selectList(wrapper);

        //查询 cleanPublicBasic
        List<CleanPublicBasic> cleanPublicBasicList = cleanPublicBasicRepository.selectList(wrapper);

        //查询 cleanPublicExtend
        List<CleanPublicExtend> cleanPublicExtendList = cleanPublicExtendRepository.selectList(wrapper);

        //查询 cleanPublicQuestion
        List<CleanPublicQuestions> cleanPublicQuestionsList = cleanPublicQuestionRepository.selectList(wrapper);

        //查询 cleanPublicFee
        List<CleanPublicFeeProject> cleanPublicFeeProjectList = cleanPublicFeeRepository.selectList(wrapper);

        //查询 cleanPublicMaterial
        List<CleanPublicMaterial> cleanPublicMaterialList = cleanPublicMaterialRepository.selectList(wrapper);

        //查询 clean_dn_audit_item_condition
        List<CleanItemCondition> cleanItemConditionList = cleanItemConditionRepository.selectList(wrapper);

        //查询 clean_dn_audit_material_condition
        List<CleanMaterialCondition> cleanMaterialConditionList = getCleanMaterialConditionList(cleanItemConditionList);

        //查询 clean_dn_task_directory
        List<CleanDirectory> cleanDirectoryList = getCleanDirectoryList(cleanBasicList, cleanPublicBasicList);


        log.info("数据导入 end, {}", System.currentTimeMillis() - start);
        return null;
    }

    public List<CleanMaterialCondition> getCleanMaterialConditionList(List<CleanItemCondition> cleanItemConditionList) {
        List<String> conditionGuidList = getConditionGuid(cleanItemConditionList);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("condition_guid", conditionGuidList);

        List<CleanMaterialCondition> cleanMaterialConditionList = cleanMaterialConditionRepository.selectList(wrapper);
        return cleanMaterialConditionList;
    }

    public List<String> getConditionGuid(List<CleanItemCondition> cleanItemConditionList) {
        List<String> conditionGuidList = new ArrayList<>();
        for(CleanItemCondition cleanItemCondition : cleanItemConditionList) {
            conditionGuidList.add(cleanItemCondition.getRowguid());
        }

        return conditionGuidList;
    }

    public List<CleanDirectory> getCleanDirectoryList(List<CleanBasic> cleanBasicList, List<CleanPublicBasic> cleanPublicBasicList) {
        List<String> catalogCodeList = getCatalogCode(cleanBasicList, cleanPublicBasicList);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.in("catalogcode", catalogCodeList);

        List<CleanDirectory> cleanDirectoryList = cleanDirectoryRepository.selectList(wrapper);
        return cleanDirectoryList;
    }

    public List<String> getCatalogCode(List<CleanBasic> cleanBasicList, List<CleanPublicBasic> cleanPublicBasicList) {
        List<String> catalogCodeList = new ArrayList<>();
        for(CleanBasic cleanBasic : cleanBasicList) {
            catalogCodeList.add(cleanBasic.getCatalogcode());
        }

        for(CleanPublicBasic cleanPublicBasic : cleanPublicBasicList) {
            catalogCodeList.add(cleanPublicBasic.getCatalogcode());
        }

        return catalogCodeList;
    }
}
