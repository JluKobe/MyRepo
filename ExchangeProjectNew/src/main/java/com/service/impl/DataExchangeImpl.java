package com.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.*;
import com.bean.entity.igt.*;
import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.config.DbContextHolder;
import com.enums.ConstantEnum;
import com.enums.DBTypeEnum;
import com.enums.DateFormatConstant;
import com.repository.*;
import com.service.IDataExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class DataExchangeImpl implements IDataExchange {

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
    private CleanPublicExtendRepository cleanPublicExtendRepository;

    @Autowired
    private CleanPublicBasicRepository cleanPublicBasicRepository;

    @Autowired
    private CleanPublicMaterialRepository cleanPublicMaterialRepository;

    @Autowired
    private CleanPublicFeeRepository cleanPublicFeeRepository;

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

    //生产环境导入
    @Override
    public ExchangeTaskHandleItemResponse doBusiness(ExchangeTaskHandleItemVo vo) {
        List<String> taskHandleItemList = vo.getTaskHandleItemList();

        log.info("数据导入 start，taskHandleItemList size : {}, 是否高频事项 : {}, 是否批量 : {}",
                taskHandleItemList.size(), vo.getIsHighFrequency(), vo.getIsBatch());
        long start = System.currentTimeMillis();
        List<String> taskGuidList = new ArrayList<>();

        for(String taskHandleItem : taskHandleItemList) {
            log.info("taskHandleItem : {}", taskHandleItem);

            //使用db2
            DbContextHolder.setDbType(DBTypeEnum.DB2);

            //1 根据taskHandleItem查询clean_dn_task_general_extend
            CleanExtend cleanExtend = cleanExtendRepository.selectOne(Wrappers.<CleanExtend>lambdaQuery()
                    .eq(CleanExtend::getTaskhandleitem, taskHandleItem));

            //根据taskHandleItem查询clean_dn_task_public_extend
            CleanPublicExtend cleanPublicExtend = cleanPublicExtendRepository.selectOne(Wrappers.<CleanPublicExtend>lambdaQuery()
                    .eq(CleanPublicExtend::getTaskhandleitem, taskHandleItem));

            if(cleanExtend != null) {
                taskGuidList.addAll(cleanGeneralTask(cleanExtend, taskHandleItem, vo));
            }

            if(cleanPublicExtend != null) {
                taskGuidList.addAll(cleanPublicTask(cleanPublicExtend, taskHandleItem, vo));
            }
        }

        ExchangeTaskHandleItemResponse exchangeTaskHandleItemResponse = ExchangeTaskHandleItemResponse.builder()
                .taskGuidList(taskGuidList)
                .build();

        log.info("数据导入 end, {}", System.currentTimeMillis() - start);
        return exchangeTaskHandleItemResponse;
    }

    public List<String> cleanGeneralTask(CleanExtend cleanExtend, String taskHandleItem, ExchangeTaskHandleItemVo vo) {
        List<String> taskGuidList = new ArrayList<>();
        String taskGuid = cleanExtend.getTaskguid();
        log.info("taskGuid : {}", taskGuid);

        //2 根据得到的taskHandleItem查询clean_dn_task_general_basic
        CleanBasic cleanBasic = cleanBasicRepository.selectOne(Wrappers.<CleanBasic>lambdaQuery().eq(CleanBasic::getTaskhandleitem, taskHandleItem));
        log.info("taskName : {}", cleanBasic.getTaskname());

        //3 查询clean_dn_task_directory得到task_name
        CleanDirectory cleanDirectory = cleanDirectoryRepository.selectOne(Wrappers.<CleanDirectory>lambdaQuery()
                .eq(CleanDirectory::getCatalogcode, cleanBasic.getCatalogcode()));

        //4 根据得到数据，在igt_task_basic新增数据，基本信息
        updateTaskBasic(cleanBasic, cleanExtend, cleanDirectory, vo);

        //5 根据得到数据，在igt_task_extend新增数据，扩展信息
        updateTaskExtend(cleanBasic, cleanExtend, vo);

        //6 根据taskHandleItem查询clean_dn_task_general_material
        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanMaterial> cleanMaterialList = cleanMaterialRepository.selectList(Wrappers.<CleanMaterial>lambdaQuery()
                .eq(CleanMaterial::getTaskhandleitem, taskHandleItem));
        log.info("materialList size : {}", cleanMaterialList.size());

        //7 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        igtMaterialRepository.delete(Wrappers.<IgtTaskMaterial>lambdaQuery()
                .eq(IgtTaskMaterial::getTaskHandleItem, taskHandleItem));
        insertMaterial(cleanMaterialList, cleanBasic, vo);

        //情形，情形关系导入
        conditionMaterialBusiness(taskHandleItem, vo);

        //12 根据taskHandleItem查询clean_dn_task_general_fee_project  收费情况
        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanFeeProject> cleanFeeProjectList = cleanFeeProjectRepository.selectList(Wrappers.<CleanFeeProject>lambdaQuery()
                .eq(CleanFeeProject::getTaskhandleitem, taskHandleItem));
        log.info("feeList size : {}", cleanFeeProjectList.size());

        //13 根据得到数据，在igt_task_fee新增数据，事项收费情况
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        igtFeeRepository.delete(Wrappers.<IgtTaskFee>lambdaQuery()
                .eq(IgtTaskFee::getTaskHandleItem, taskHandleItem));
        insertFee(cleanFeeProjectList, vo);

        taskGuidList.add(taskGuid);

        return taskGuidList;
    }

    private void conditionMaterialBusiness(String taskHandleItem, ExchangeTaskHandleItemVo vo) {
        //8 根据taskHandleItem查询clean_dn_audit_item_condition
        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanItemCondition> cleanItemConditionList = cleanItemConditionRepository.selectList(Wrappers.<CleanItemCondition>lambdaQuery()
                .eq(CleanItemCondition::getTaskhandleitem, taskHandleItem));
        log.info("conditionList size : {}", cleanItemConditionList.size());

        //9 根据得到数据，在igt_task_condition新增数据，事项情形
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        List<IgtTaskCondition> igtTaskConditionList = igtConditionRepository.selectList(Wrappers.<IgtTaskCondition>lambdaQuery()
                .eq(IgtTaskCondition::getTaskHandleItem, taskHandleItem));
        igtConditionRepository.delete(Wrappers.<IgtTaskCondition>lambdaQuery()
                .eq(IgtTaskCondition::getTaskHandleItem, taskHandleItem));
        insertCondition(cleanItemConditionList, vo);
        for (IgtTaskCondition igtTaskCondition : igtTaskConditionList) {
            igtConditionMaterialRepository.delete(Wrappers.<IgtTaskConditionMaterial>lambdaQuery()
                    .eq(IgtTaskConditionMaterial::getConditionGuid, igtTaskCondition.getConditionGuid()));
        }

        //10 根据condition_guid查询clean_dn_audit_material_condition
        List<String> conditionGuidList = new ArrayList<>();
        for (CleanItemCondition cleanItemCondition : cleanItemConditionList) {
            String conditionGuid = cleanItemCondition.getRowguid();
            conditionGuidList.add(conditionGuid);
        }

        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanMaterialCondition> cleanMaterialConditionList = new ArrayList<>();
        for (String conditionGuid : conditionGuidList) {
            List<CleanMaterialCondition> cleanMaterialConditions = cleanMaterialConditionRepository
                    .selectList(Wrappers.<CleanMaterialCondition>lambdaQuery().eq(CleanMaterialCondition::getConditionGuid, conditionGuid));
            cleanMaterialConditionList.addAll(cleanMaterialConditions);
        }
        log.info("materialConditionList size : {}", cleanMaterialConditionList.size());

        //11 根据得到数据，在igt_task_condition_material新增数据，情形材料关系
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        if (cleanMaterialConditionList.size() > 0) {
            insertConditionMaterial(cleanMaterialConditionList, vo);
        }
    }

    public List<String> cleanPublicTask(CleanPublicExtend cleanPublicExtend, String taskHandleItem, ExchangeTaskHandleItemVo vo) {
        List<String> taskGuidList = new ArrayList<>();
        String taskGuid = cleanPublicExtend.getTaskguid();
        log.info("taskGuid : {}", taskGuid);

        //2 根据得到的taskHandleItem查询clean_dn_task_public_basic
        CleanPublicBasic cleanPublicBasic = cleanPublicBasicRepository.selectOne(Wrappers.<CleanPublicBasic>lambdaQuery()
                .eq(CleanPublicBasic::getTaskhandleitem, taskHandleItem));
        log.info("taskName : {}", cleanPublicBasic.getTaskname());

        //3 查询clean_dn_task_directory得到task_name
        CleanDirectory cleanDirectory = cleanDirectoryRepository.selectOne(Wrappers.<CleanDirectory>lambdaQuery()
                .eq(CleanDirectory::getCatalogcode, cleanPublicBasic.getCatalogcode()));

        //4 根据得到数据，在igt_task_basic新增数据，基本信息
        updatePublicBasic(cleanPublicBasic, cleanPublicExtend, cleanDirectory, vo);

        //5 根据得到数据，在igt_task_extend新增数据，扩展信息
        updatePublicExtend(cleanPublicBasic, cleanPublicExtend, vo);

        //6 根据taskHandleItem查询clean_dn_task_general_material
        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanPublicMaterial> cleanPublicMaterialList = cleanPublicMaterialRepository.selectList(Wrappers.<CleanPublicMaterial>lambdaQuery()
                .eq(CleanPublicMaterial::getTaskhandleitem, taskHandleItem));
        log.info("materialList size : {}", cleanPublicMaterialList.size());

        //7 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息
        DbContextHolder.setDbType(DBTypeEnum.DB1);
        igtMaterialRepository.delete(Wrappers.<IgtTaskMaterial>lambdaQuery()
                .eq(IgtTaskMaterial::getTaskHandleItem, taskHandleItem));
        insertPublicMaterial(cleanPublicMaterialList, cleanPublicBasic, vo);
        taskGuidList.add(taskGuid);

        //情形，情形关系导入
        conditionMaterialBusiness(taskHandleItem, vo);

        //12 根据taskHandleItem查询clean_dn_task_general_fee_project  收费情况
        DbContextHolder.setDbType(DBTypeEnum.DB2);
        List<CleanPublicFeeProject> cleanFeeProjectList = cleanPublicFeeRepository.selectList(Wrappers.<CleanPublicFeeProject>lambdaQuery()
                .eq(CleanPublicFeeProject::getTaskhandleitem, taskHandleItem));
        log.info("feeList size : {}", cleanFeeProjectList.size());

        //13 根据得到数据，在igt_task_fee新增数据，事项收费情况
        DbContextHolder.setDbType(DBTypeEnum.DB1);
        igtFeeRepository.delete(Wrappers.<IgtTaskFee>lambdaQuery()
                .eq(IgtTaskFee::getTaskHandleItem, taskHandleItem));
        insertPublicFee(cleanFeeProjectList, vo);

        return taskGuidList;
    }

    public void updatePublicBasic(CleanPublicBasic cleanPublicBasic, CleanPublicExtend cleanPublicExtend,
                                  CleanDirectory cleanDirectory, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.DB1);
        String currentTime = getCurrentTime();

        IgtTaskBasic igtTaskBasic = igtBasicRepository.selectOne(Wrappers.<IgtTaskBasic>lambdaQuery()
                .eq(IgtTaskBasic::getTaskHandleItem, cleanPublicBasic.getTaskhandleitem()));

        if(igtTaskBasic == null) {
            IgtTaskBasic igtTaskBasicObj = IgtTaskBasic.builder()
                    .id(cleanPublicBasic.getId())
                    .catalogCode(cleanPublicBasic.getCatalogcode())
                    .catalogName(cleanDirectory.getTaskname())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .deptCode(cleanPublicBasic.getDeptcode())
                    .deptName(cleanPublicBasic.getDeptname())
                    .deptType(cleanPublicBasic.getDepttype())
                    .handleType(cleanPublicBasic.getHandletype())
                    .isBatch(vo.getIsBatch())
                    .isEntryCenter(cleanPublicExtend.getIsentrycenter())
                    .isExpress(cleanPublicExtend.getIsexpress())
                    .isHighFrequency(vo.getIsHighFrequency())
                    .isOnline(cleanPublicExtend.getIsonline())
                    .isPayOnline(cleanPublicExtend.getIspayonline())
                    .isSchedule(cleanPublicExtend.getIsschedule())
                    .isServiceTerminals(cleanPublicExtend.getIsserviceterminals())
                    .isWindow(cleanPublicExtend.getIsentrycenter())
                    .linkWay(cleanPublicBasic.getLinkway())
                    .localCatalogCode(cleanPublicBasic.getLocalcatalogcode())
                    .localTaskCode(cleanPublicBasic.getLocaltaskcode())
                    .powerSource(null)
                    .productSourceType(ConstantEnum.PRODUCT_SOURCE_TYPE.code())
                    .productType(ConstantEnum.PRODUCT_TYPE.code())
                    .projectType(cleanPublicBasic.getProjecttype())
                    .promiseDay(cleanPublicBasic.getPromiseday())
                    .resultName(cleanPublicExtend.getResultname())
                    .resultType(cleanPublicExtend.getResulttype())
                    .resultSample(ConstantEnum.RESULT_SAMPLE.code())
                    .serverType(cleanPublicBasic.getServertype())
                    .taskArea(ConstantEnum.TASK_AREA.code())
                    .taskCode(cleanPublicBasic.getTaskcode())
                    .taskGuid(cleanPublicExtend.getTaskguid())
                    .taskHandleItem(cleanPublicBasic.getTaskhandleitem())
                    .taskName(cleanPublicBasic.getTaskname())
                    .taskState(cleanPublicBasic.getTaskstate())
                    .taskStatus(ConstantEnum.TASK_STATUS.code())
                    .taskType(cleanPublicBasic.getTasktype())
                    .taskVersion(cleanPublicBasic.getTaskversion())
                    .transactAddr(cleanPublicBasic.getTransactaddr())
                    .transactTime(cleanPublicBasic.getTransacttime())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .useLevel(cleanPublicBasic.getUselevel())
                    .version(vo.getVersion())
                    .build();
            igtBasicRepository.insert(igtTaskBasicObj);
        }

        else {
            igtTaskBasic.setId(cleanPublicBasic.getId());
            igtTaskBasic.setCatalogCode(cleanPublicBasic.getCatalogcode());
            igtTaskBasic.setCatalogName(cleanDirectory.getTaskname());
            igtTaskBasic.setDeptCode(cleanPublicBasic.getDeptcode());
            igtTaskBasic.setDeptName(cleanPublicBasic.getDeptname());
            igtTaskBasic.setDeptType(cleanPublicBasic.getDepttype());
            igtTaskBasic.setHandleType(cleanPublicBasic.getHandletype());
            igtTaskBasic.setIsBatch(vo.getIsBatch());
            igtTaskBasic.setIsEntryCenter(cleanPublicExtend.getIsentrycenter());
            igtTaskBasic.setIsExpress(cleanPublicExtend.getIsexpress());
            igtTaskBasic.setIsHighFrequency(vo.getIsHighFrequency());
            igtTaskBasic.setIsOnline(cleanPublicExtend.getIsonline());
            igtTaskBasic.setIsPayOnline(cleanPublicExtend.getIspayonline());
            igtTaskBasic.setIsSchedule(cleanPublicExtend.getIsschedule());
            igtTaskBasic.setIsServiceTerminals(cleanPublicExtend.getIsserviceterminals());
            igtTaskBasic.setIsWindow(cleanPublicExtend.getIsentrycenter());
            igtTaskBasic.setLinkWay(cleanPublicBasic.getLinkway());
            igtTaskBasic.setLocalCatalogCode(cleanPublicBasic.getLocalcatalogcode());
            igtTaskBasic.setLocalTaskCode(cleanPublicBasic.getLocaltaskcode());
            igtTaskBasic.setPowerSource(null);
            igtTaskBasic.setProjectType(cleanPublicBasic.getProjecttype());
            igtTaskBasic.setPromiseDay(cleanPublicBasic.getPromiseday());
            igtTaskBasic.setResultName(cleanPublicExtend.getResultname());
            igtTaskBasic.setResultType(cleanPublicExtend.getResulttype());
            igtTaskBasic.setServerType(cleanPublicBasic.getServertype());
            igtTaskBasic.setTaskCode(cleanPublicBasic.getTaskcode());
            igtTaskBasic.setTaskGuid(cleanPublicExtend.getTaskguid());
            igtTaskBasic.setTaskName(cleanPublicBasic.getTaskname());
            igtTaskBasic.setTaskState(cleanPublicBasic.getTaskstate());
            igtTaskBasic.setTaskType(cleanPublicBasic.getTasktype());
            igtTaskBasic.setTaskVersion(cleanPublicBasic.getTaskversion());
            igtTaskBasic.setTransactAddr(cleanPublicBasic.getTransactaddr());
            igtTaskBasic.setTransactTime(cleanPublicBasic.getTransacttime());
            igtTaskBasic.setUpdateTime(currentTime);
            igtTaskBasic.setUseLevel(cleanPublicBasic.getUselevel());
            igtTaskBasic.setVersion(vo.getVersion());

            igtBasicRepository.update(igtTaskBasic, Wrappers.<IgtTaskBasic>lambdaQuery()
                    .eq(IgtTaskBasic::getTaskHandleItem, cleanPublicBasic.getTaskhandleitem()));
        }
    }

    public void updateTaskBasic(CleanBasic cleanBasic, CleanExtend cleanExtend, CleanDirectory cleanDirectory, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        String currentTime = getCurrentTime();

        IgtTaskBasic igtTaskBasic = igtBasicRepository.selectOne(Wrappers.<IgtTaskBasic>lambdaQuery()
                .eq(IgtTaskBasic::getTaskHandleItem, cleanBasic.getTaskhandleitem()));

        if(igtTaskBasic == null) {
            IgtTaskBasic igtTaskBasicObj = IgtTaskBasic.builder()
                    .id(cleanBasic.getId())
                    .catalogCode(cleanBasic.getCatalogcode())
                    .catalogName(cleanDirectory.getTaskname())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .deptCode(cleanBasic.getDeptcode())
                    .deptName(cleanBasic.getDeptname())
                    .deptType(cleanBasic.getDepttype())
                    .handleType(cleanBasic.getHandletype())
                    .isBatch(vo.getIsBatch())
                    .isEntryCenter(cleanExtend.getIsentrycenter())
                    .isExpress(cleanExtend.getIsexpress())
                    .isHighFrequency(vo.getIsHighFrequency())
                    .isOnline(cleanExtend.getIsonline())
                    .isPayOnline(cleanExtend.getIspayonline())
                    .isSchedule(cleanExtend.getIsschedule())
                    .isServiceTerminals(cleanExtend.getIsserviceterminals())
                    .isWindow(cleanExtend.getIsentrycenter())
                    .linkWay(cleanBasic.getLinkway())
                    .localCatalogCode(cleanBasic.getLocalcatalogcode())
                    .localTaskCode(cleanBasic.getLocaltaskcode())
                    .powerSource(cleanBasic.getPowersource())
                    .productSourceType(ConstantEnum.PRODUCT_SOURCE_TYPE.code())
                    .productType(ConstantEnum.PRODUCT_TYPE.code())
                    .projectType(cleanBasic.getProjecttype())
                    .promiseDay(cleanBasic.getPromiseday())
                    .resultName(cleanExtend.getResultname())
                    .resultType(cleanExtend.getResulttype())
                    .resultSample(ConstantEnum.RESULT_SAMPLE.code())
                    .serverType(cleanBasic.getServertype())
                    .taskArea(ConstantEnum.TASK_AREA.code())
                    .taskCode(cleanBasic.getTaskcode())
                    .taskGuid(cleanExtend.getTaskguid())
                    .taskHandleItem(cleanBasic.getTaskhandleitem())
                    .taskName(cleanBasic.getTaskname())
                    .taskState(cleanBasic.getTaskstate())
                    .taskStatus(ConstantEnum.TASK_STATUS.code())
                    .taskType(cleanBasic.getTasktype())
                    .taskVersion(cleanBasic.getTaskversion())
                    .transactAddr(cleanBasic.getTransactaddr())
                    .transactTime(cleanBasic.getTransacttime())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .useLevel(cleanBasic.getUselevel())
                    .version(vo.getVersion())
                    .acceptCenterCode(null)
                    .build();
            igtBasicRepository.insert(igtTaskBasicObj);
        }

        else {
            igtTaskBasic.setId(cleanBasic.getId());
            igtTaskBasic.setCatalogCode(cleanBasic.getCatalogcode());
            igtTaskBasic.setCatalogName(cleanDirectory.getTaskname());
            igtTaskBasic.setDeptCode(cleanBasic.getDeptcode());
            igtTaskBasic.setDeptName(cleanBasic.getDeptname());
            igtTaskBasic.setDeptType(cleanBasic.getDepttype());
            igtTaskBasic.setHandleType(cleanBasic.getHandletype());
            igtTaskBasic.setIsBatch(vo.getIsBatch());
            igtTaskBasic.setIsEntryCenter(cleanExtend.getIsentrycenter());
            igtTaskBasic.setIsExpress(cleanExtend.getIsexpress());
            igtTaskBasic.setIsHighFrequency(vo.getIsHighFrequency());
            igtTaskBasic.setIsOnline(cleanExtend.getIsonline());
            igtTaskBasic.setIsPayOnline(cleanExtend.getIspayonline());
            igtTaskBasic.setIsSchedule(cleanExtend.getIsschedule());
            igtTaskBasic.setIsServiceTerminals(cleanExtend.getIsserviceterminals());
            igtTaskBasic.setIsWindow(cleanExtend.getIsentrycenter());
            igtTaskBasic.setLinkWay(cleanBasic.getLinkway());
            igtTaskBasic.setLocalCatalogCode(cleanBasic.getLocalcatalogcode());
            igtTaskBasic.setLocalTaskCode(cleanBasic.getLocaltaskcode());
            igtTaskBasic.setPowerSource(cleanBasic.getPowersource());
            igtTaskBasic.setProjectType(cleanBasic.getProjecttype());
            igtTaskBasic.setPromiseDay(cleanBasic.getPromiseday());
            igtTaskBasic.setResultName(cleanExtend.getResultname());
            igtTaskBasic.setResultType(cleanExtend.getResulttype());
            igtTaskBasic.setServerType(cleanBasic.getServertype());
            igtTaskBasic.setTaskCode(cleanBasic.getTaskcode());
            igtTaskBasic.setTaskGuid(cleanExtend.getTaskguid());
            igtTaskBasic.setTaskName(cleanBasic.getTaskname());
            igtTaskBasic.setTaskState(cleanBasic.getTaskstate());
            igtTaskBasic.setTaskType(cleanBasic.getTasktype());
            igtTaskBasic.setTaskVersion(cleanBasic.getTaskversion());
            igtTaskBasic.setTransactAddr(cleanBasic.getTransactaddr());
            igtTaskBasic.setTransactTime(cleanBasic.getTransacttime());
            igtTaskBasic.setUpdateTime(currentTime);
            igtTaskBasic.setUseLevel(cleanBasic.getUselevel());
            igtTaskBasic.setVersion(vo.getVersion());

            igtBasicRepository.update(igtTaskBasic, Wrappers.<IgtTaskBasic>lambdaQuery()
                    .eq(IgtTaskBasic::getTaskHandleItem, cleanBasic.getTaskhandleitem()));
        }
    }

    public void updatePublicExtend(CleanPublicBasic cleanPublicBasic, CleanPublicExtend cleanPublicExtend, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.DB1);
        String currentTime = getCurrentTime();

        IgtTaskExtend igtTaskExtend = igtExtendRepository.selectOne(Wrappers.<IgtTaskExtend>lambdaQuery()
                .eq(IgtTaskExtend::getTaskHandleItem, cleanPublicBasic.getTaskhandleitem()));

        if(igtTaskExtend == null) {
            IgtTaskExtend igtTaskExtendObj = IgtTaskExtend.builder()
                    .id(cleanPublicBasic.getId())
                    .acceptCondition(cleanPublicBasic.getAcceptcondition())
                    .anticipateDay(cleanPublicBasic.getAnticipateday())
                    .anticipateExplain(cleanPublicBasic.getAnticipateexplain())
                    .anticipateType(cleanPublicBasic.getAnticipatetype())
                    .appIsSingleLogin(cleanPublicBasic.getAppissinglelogin())
                    .byLaw(cleanPublicBasic.getBylaw())
                    .bySuppose(ConstantEnum.BY_SUPPPOSE.code())
                    .cdBatch(cleanPublicBasic.getCdBatch())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .entrustName(cleanPublicBasic.getEntrustname())
                    .handleArea(cleanPublicExtend.getHandlearea())
                    .handleFlow(cleanPublicBasic.getHandleflow())
                    .isSingleLogin(cleanPublicBasic.getIssinglelogin())
                    .limitSceneExplain(cleanPublicExtend.getLimitsceneexplain())
                    .limitSceneNum(cleanPublicBasic.getLimitscenenum())
                    .linkAddr(cleanPublicBasic.getLinkaddr())
                    .mobileTerminalUrl(cleanPublicBasic.getMobileterminalurl())
                    .onlineHandleDepth(cleanPublicExtend.getOnlinehandledepth())
                    .onlineHandleUrl(cleanPublicExtend.getOnlinehandleurl())
                    .otherDept(cleanPublicExtend.getOtherdept())
                    .planCancelDate(cleanPublicBasic.getPlancanceldate())
                    .planEffectiveDate(cleanPublicBasic.getPlaneffectivedate())
                    .promiseExplain(cleanPublicBasic.getPromiseexplain())
                    .promiseType(cleanPublicBasic.getPromisetype())
                    .serviceType(cleanPublicExtend.getServicetype())
                    .specialProcedure(cleanPublicBasic.getSpecialprocedure())
                    .superviseWay(cleanPublicBasic.getSuperviseway())
                    .taskGuid(cleanPublicExtend.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanPublicBasic.getTaskhandleitem())
                    .build();
            igtExtendRepository.insert(igtTaskExtendObj);
        }

        else {
            igtTaskExtend.setId(cleanPublicExtend.getId());
            igtTaskExtend.setAcceptCondition(cleanPublicBasic.getAcceptcondition());
            igtTaskExtend.setAnticipateDay(cleanPublicBasic.getAnticipateday());
            igtTaskExtend.setAnticipateExplain(cleanPublicBasic.getAnticipateexplain());
            igtTaskExtend.setAnticipateType(cleanPublicBasic.getAnticipatetype());
            igtTaskExtend.setAppIsSingleLogin(cleanPublicBasic.getAppissinglelogin());
            igtTaskExtend.setByLaw(cleanPublicBasic.getBylaw());
            igtTaskExtend.setCdBatch(cleanPublicBasic.getCdBatch());
            igtTaskExtend.setEntrustName(cleanPublicBasic.getEntrustname());
            igtTaskExtend.setHandleArea(cleanPublicExtend.getHandlearea());
            igtTaskExtend.setHandleFlow(cleanPublicBasic.getHandleflow());
            igtTaskExtend.setIsSingleLogin(cleanPublicBasic.getIssinglelogin());
            igtTaskExtend.setLimitSceneExplain(cleanPublicExtend.getLimitsceneexplain());
            igtTaskExtend.setLimitSceneNum(cleanPublicBasic.getLimitscenenum());
            igtTaskExtend.setLinkAddr(cleanPublicBasic.getLinkaddr());
            igtTaskExtend.setMobileTerminalUrl(cleanPublicBasic.getMobileterminalurl());
            igtTaskExtend.setOnlineHandleDepth(cleanPublicExtend.getOnlinehandledepth());
            igtTaskExtend.setOnlineHandleUrl(cleanPublicExtend.getOnlinehandleurl());
            igtTaskExtend.setOtherDept(cleanPublicExtend.getOtherdept());
            igtTaskExtend.setPlanCancelDate(cleanPublicBasic.getPlancanceldate());
            igtTaskExtend.setPlanEffectiveDate(cleanPublicBasic.getPlaneffectivedate());
            igtTaskExtend.setPromiseExplain(cleanPublicBasic.getPromiseexplain());
            igtTaskExtend.setPromiseType(cleanPublicBasic.getPromisetype());
            igtTaskExtend.setServiceType(cleanPublicExtend.getServicetype());
            igtTaskExtend.setSpecialProcedure(cleanPublicBasic.getSpecialprocedure());
            igtTaskExtend.setSuperviseWay(cleanPublicBasic.getSuperviseway());
            igtTaskExtend.setTaskGuid(cleanPublicExtend.getTaskguid());
            igtTaskExtend.setUpdateTime(currentTime);
            igtTaskExtend.setVersion(vo.getVersion());

            igtExtendRepository.update(igtTaskExtend, Wrappers.<IgtTaskExtend>lambdaQuery()
                    .eq(IgtTaskExtend::getTaskHandleItem, cleanPublicBasic.getTaskhandleitem()));
        }
    }

    public void updateTaskExtend(CleanBasic cleanBasic, CleanExtend cleanExtend, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.DB3);
        String currentTime = getCurrentTime();

        IgtTaskExtend igtTaskExtend = igtExtendRepository.selectOne(Wrappers.<IgtTaskExtend>lambdaQuery()
                .eq(IgtTaskExtend::getTaskHandleItem, cleanBasic.getTaskhandleitem()));

        if(igtTaskExtend == null) {
            IgtTaskExtend igtTaskExtendObj = IgtTaskExtend.builder()
                    .id(cleanExtend.getId())
                    .acceptCondition(cleanBasic.getAcceptcondition())
                    .anticipateDay(cleanBasic.getAnticipateday())
                    .anticipateExplain(cleanBasic.getAnticipateexplain())
                    .anticipateType(cleanBasic.getAnticipatetype())
                    .appIsSingleLogin(cleanBasic.getAppissinglelogin())
                    .byLaw(cleanBasic.getBylaw())
                    .bySuppose(ConstantEnum.BY_SUPPPOSE.code())
                    .cdBatch(cleanBasic.getCdBatch())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .entrustName(cleanBasic.getEntrustname())
                    .handleArea(cleanExtend.getHandlearea())
                    .handleFlow(cleanBasic.getHandleflow())
                    .isSingleLogin(cleanBasic.getIssinglelogin())
                    .limitSceneExplain(cleanExtend.getLimitsceneexplain())
                    .limitSceneNum(cleanBasic.getLimitscenenum())
                    .linkAddr(cleanBasic.getLinkaddr())
                    .mobileTerminalUrl(cleanBasic.getMobileterminalurl())
                    .onlineHandleDepth(cleanExtend.getOnlinehandledepth())
                    .onlineHandleUrl(cleanExtend.getOnlinehandleurl())
                    .otherDept(cleanExtend.getOtherdept())
                    .planCancelDate(cleanBasic.getPlancanceldate())
                    .planEffectiveDate(cleanBasic.getPlaneffectivedate())
                    .promiseExplain(cleanBasic.getPromiseexplain())
                    .promiseType(cleanBasic.getPromisetype())
                    .serviceType(cleanExtend.getServicetype())
                    .specialProcedure(cleanBasic.getSpecialprocedure())
                    .superviseWay(cleanBasic.getSuperviseway())
                    .taskGuid(cleanExtend.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanBasic.getTaskhandleitem())
                    .build();
            igtExtendRepository.insert(igtTaskExtendObj);
        }

        else {
            igtTaskExtend.setId(cleanExtend.getId());
            igtTaskExtend.setAcceptCondition(cleanBasic.getAcceptcondition());
            igtTaskExtend.setAnticipateDay(cleanBasic.getAnticipateday());
            igtTaskExtend.setAnticipateExplain(cleanBasic.getAnticipateexplain());
            igtTaskExtend.setAnticipateType(cleanBasic.getAnticipatetype());
            igtTaskExtend.setAppIsSingleLogin(cleanBasic.getAppissinglelogin());
            igtTaskExtend.setByLaw(cleanBasic.getBylaw());
            igtTaskExtend.setCdBatch(cleanBasic.getCdBatch());
            igtTaskExtend.setEntrustName(cleanBasic.getEntrustname());
            igtTaskExtend.setHandleArea(cleanExtend.getHandlearea());
            igtTaskExtend.setHandleFlow(cleanBasic.getHandleflow());
            igtTaskExtend.setIsSingleLogin(cleanBasic.getIssinglelogin());
            igtTaskExtend.setLimitSceneExplain(cleanExtend.getLimitsceneexplain());
            igtTaskExtend.setLimitSceneNum(cleanBasic.getLimitscenenum());
            igtTaskExtend.setLinkAddr(cleanBasic.getLinkaddr());
            igtTaskExtend.setMobileTerminalUrl(cleanBasic.getMobileterminalurl());
            igtTaskExtend.setOnlineHandleDepth(cleanExtend.getOnlinehandledepth());
            igtTaskExtend.setOnlineHandleUrl(cleanExtend.getOnlinehandleurl());
            igtTaskExtend.setOtherDept(cleanExtend.getOtherdept());
            igtTaskExtend.setPlanCancelDate(cleanBasic.getPlancanceldate());
            igtTaskExtend.setPlanEffectiveDate(cleanBasic.getPlaneffectivedate());
            igtTaskExtend.setPromiseExplain(cleanBasic.getPromiseexplain());
            igtTaskExtend.setPromiseType(cleanBasic.getPromisetype());
            igtTaskExtend.setServiceType(cleanExtend.getServicetype());
            igtTaskExtend.setSpecialProcedure(cleanBasic.getSpecialprocedure());
            igtTaskExtend.setSuperviseWay(cleanBasic.getSuperviseway());
            igtTaskExtend.setTaskGuid(cleanExtend.getTaskguid());
            igtTaskExtend.setUpdateTime(currentTime);
            igtTaskExtend.setVersion(vo.getVersion());

            igtExtendRepository.update(igtTaskExtend, Wrappers.<IgtTaskExtend>lambdaQuery()
                    .eq(IgtTaskExtend::getTaskHandleItem, cleanBasic.getTaskhandleitem()));
        }
    }

    public void insertPublicMaterial(List<CleanPublicMaterial> cleanPublicMaterialList, CleanPublicBasic cleanPublicBasic,ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanPublicMaterial cleanMaterial : cleanPublicMaterialList) {
            IgtTaskMaterial igtTaskMaterial = IgtTaskMaterial.builder()
                    .id(cleanMaterial.getId())
                    .areaCode(cleanPublicBasic.getAreacode())
                    .acceptStand(cleanMaterial.getAcceptstand())
                    .byLaw(cleanMaterial.getBylaw())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .exampleGuid(cleanMaterial.getExampleguid())
                    .fillExplain(cleanMaterial.getFillexplain())
                    .formGuid(cleanMaterial.getFormguid())
                    .handleType(cleanPublicBasic.getHandletype())
                    .isNeed(cleanMaterial.getIsneed())
                    .isReused(ConstantEnum.IS_REUSED.code())
                    .materialFormat(cleanMaterial.getMaterialformat())
                    .materialGuid(cleanMaterial.getRowguid())
                    .materialName(cleanMaterial.getMaterialname())
                    .materialType(cleanMaterial.getMaterialtype())
                    .pageFormat(cleanMaterial.getPageformat())
                    .pageNum(cleanMaterial.getPagenum())
                    .sourceExplain(cleanMaterial.getSourceexplain())
                    .sourceType(cleanMaterial.getSourcetype())
                    .taskGuid(cleanMaterial.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanPublicBasic.getTaskhandleitem())
                    .build();
            igtMaterialRepository.insert(igtTaskMaterial);
        }
    }

    public void insertMaterial(List<CleanMaterial> cleanMaterialList, CleanBasic cleanBasic, ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanMaterial cleanMaterial : cleanMaterialList) {
            IgtTaskMaterial igtTaskMaterial = IgtTaskMaterial.builder()
                    .id(cleanMaterial.getId())
                    .areaCode(cleanBasic.getAreacode())
                    .acceptStand(cleanMaterial.getAcceptstand())
                    .byLaw(cleanMaterial.getBylaw())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .exampleGuid(cleanMaterial.getExampleguid())
                    .fillExplain(cleanMaterial.getFillexplain())
                    .formGuid(cleanMaterial.getFormguid())
                    .handleType(cleanBasic.getHandletype())
                    .isNeed(cleanMaterial.getIsneed())
                    .isReused(ConstantEnum.IS_REUSED.code())
                    .materialFormat(cleanMaterial.getMaterialformat())
                    .materialGuid(cleanMaterial.getRowguid())
                    .materialName(cleanMaterial.getMaterialname())
                    .materialType(cleanMaterial.getMaterialtype())
                    .pageFormat(cleanMaterial.getPageformat())
                    .pageNum(cleanMaterial.getPagenum())
                    .sourceExplain(cleanMaterial.getSourceexplain())
                    .sourceType(cleanMaterial.getSourcetype())
                    .taskGuid(cleanMaterial.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanBasic.getTaskhandleitem())
                    .build();
            igtMaterialRepository.insert(igtTaskMaterial);
        }
    }

    public void insertCondition(List<CleanItemCondition> cleanItemConditionList, ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanItemCondition cleanItemCondition : cleanItemConditionList) {
            IgtTaskCondition igtTaskCondition = IgtTaskCondition.builder()
                    .id(cleanItemCondition.getId())
                    .conditionDesc(cleanItemCondition.getConditionDesc())
                    .conditionGuid(cleanItemCondition.getRowguid())
                    .conditionName(cleanItemCondition.getConditionName())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .taskGuid(cleanItemCondition.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanItemCondition.getTaskhandleitem())
                    .build();
            igtConditionRepository.insert(igtTaskCondition);
        }
    }

    public void insertFee(List<CleanFeeProject> cleanFeeProjectList, ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanFeeProject cleanFeeProject : cleanFeeProjectList) {
            IgtTaskFee igtTaskFee = IgtTaskFee.builder()
                    .id(cleanFeeProject.getId())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .descExplain(cleanFeeProject.getDescexplain())
                    .feeName(cleanFeeProject.getFeename())
                    .feeStand(cleanFeeProject.getFeestand())
                    .isDesc(cleanFeeProject.getIsdesc())
                    .taskGuid(cleanFeeProject.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanFeeProject.getTaskhandleitem())
                    .build();
            igtFeeRepository.insert(igtTaskFee);
        }
    }

    public void insertPublicFee(List<CleanPublicFeeProject> cleanPublicFeeProjectList, ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanPublicFeeProject cleanPublicFeeProject : cleanPublicFeeProjectList) {
            IgtTaskFee igtTaskFee = IgtTaskFee.builder()
                    .id(cleanPublicFeeProject.getId())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .descExplain(cleanPublicFeeProject.getDescexplain())
                    .feeName(cleanPublicFeeProject.getFeename())
                    .feeStand(cleanPublicFeeProject.getFeestand())
                    .isDesc(cleanPublicFeeProject.getIsdesc())
                    .taskGuid(cleanPublicFeeProject.getTaskguid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .taskHandleItem(cleanPublicFeeProject.getTaskhandleitem())
                    .build();
            igtFeeRepository.insert(igtTaskFee);
        }
    }

    private String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormatConstant.FORMAT_SEC_LEVEL);
        return sdf.format(date);
    }

    public void insertConditionMaterial(List<CleanMaterialCondition> cleanMaterialConditionList, ExchangeTaskHandleItemVo vo) {
        String currentTime = getCurrentTime();

        for(CleanMaterialCondition cleanMaterialCondition : cleanMaterialConditionList) {
            IgtTaskConditionMaterial igtTaskConditionMaterial = IgtTaskConditionMaterial.builder()
                    .id(cleanMaterialCondition.getId())
                    .conditionGuid(cleanMaterialCondition.getConditionGuid())
                    .createOrgId(vo.getCreateOrgId())
                    .createTime(currentTime)
                    .createUserId(vo.getCreateUserId())
                    .materialGuid(cleanMaterialCondition.getMaterialGuid())
                    .updateOrgId(vo.getUpdateOrgId())
                    .updateTime(currentTime)
                    .updateUserId(vo.getUpdateUserId())
                    .version(vo.getVersion())
                    .build();
            igtConditionMaterialRepository.insert(igtTaskConditionMaterial);
        }
    }
}
