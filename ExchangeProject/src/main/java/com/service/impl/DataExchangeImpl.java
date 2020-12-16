package com.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.*;
import com.bean.entity.igt.*;
import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.config.DbContextHolder;
import com.enums.DBTypeEnum;
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

    @Override
    public ExchangeTaskHandleItemResponse doBusiness(ExchangeTaskHandleItemVo vo) {
        List<String> taskHandleItemList = vo.getTaskHandleItemList();

        log.info("数据导入 start，taskHandleItemList size : {}, 是否高频事项 : {}", taskHandleItemList.size(), vo.getIsHighFrequency());
        long start = System.currentTimeMillis();
        List<String> taskGuidList = new ArrayList<>();

        for(String taskHandleItem : taskHandleItemList) {
            log.info("taskHandleItem : {}", taskHandleItem);

            //使用db2
            DbContextHolder.setDbType(DBTypeEnum.db2);

            //1 根据taskHandleItem查询clean_dn_task_general_extend
            CleanExtend cleanExtend = cleanExtendRepository.selectOne(Wrappers.<CleanExtend>lambdaQuery()
                    .eq(CleanExtend::getTaskhandleitem, taskHandleItem));
            String taskGuid = cleanExtend.getTaskguid();
            log.info("taskGuid : {}", taskGuid);

            //2 根据得到的taskGuid查询clean_dn_task_general_basic
            CleanBasic cleanBasic = cleanBasicRepository.selectOne(Wrappers.<CleanBasic>lambdaQuery().eq(CleanBasic::getRowguid, taskGuid));
            log.info("taskName : {}", cleanBasic.getTaskname());

            //3 查询clean_dn_task_directory得到task_name
            CleanDirectory cleanDirectory = cleanDirectoryRepository.selectOne(Wrappers.<CleanDirectory>lambdaQuery()
                    .eq(CleanDirectory::getCatalogcode, cleanBasic.getCatalogcode()));

            //4 根据得到数据，在igt_task_basic新增数据，基本信息
            insertTaskBasic(cleanBasic, cleanExtend, cleanDirectory, vo);

            //5 根据得到数据，在igt_task_extend新增数据，扩展信息
            insertTaskExtend(cleanBasic, cleanExtend, vo);

            //6 根据task_guid查询clean_dn_task_general_material
            DbContextHolder.setDbType(DBTypeEnum.db2);
            List<CleanMaterial> cleanMaterialList = cleanMaterialRepository.selectList(Wrappers.<CleanMaterial>lambdaQuery()
                    .eq(CleanMaterial::getTaskguid, taskGuid));
            log.info("materialList size : {}", cleanMaterialList.size());

            //7 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息
            insertMaterial(cleanMaterialList, cleanBasic, vo);

            //8 根据taskGuid查询clean_dn_audit_item_condition
            DbContextHolder.setDbType(DBTypeEnum.db2);
            List<CleanItemCondition> cleanItemConditionList = cleanItemConditionRepository.selectList(Wrappers.<CleanItemCondition>lambdaQuery()
                    .eq(CleanItemCondition::getTaskguid, taskGuid));
            log.info("conditionList size : {}", cleanItemConditionList.size());

            //9 根据得到数据，在igt_task_condition新增数据，事项情形
            insertCondition(cleanItemConditionList, vo);

            //10 根据condition_guid查询clean_dn_audit_material_condition
            List<String> conditionGuidList = new ArrayList<>();
            for(CleanItemCondition cleanItemCondition : cleanItemConditionList) {
                String conditionGuid = cleanItemCondition.getRowguid();
                conditionGuidList.add(conditionGuid);
            }

            DbContextHolder.setDbType(DBTypeEnum.db2);
            List<CleanMaterialCondition> cleanMaterialConditionList = new ArrayList<>();
            for(String conditionGuid : conditionGuidList) {
                List<CleanMaterialCondition> cleanMaterialConditions = cleanMaterialConditionRepository
                        .selectList(Wrappers.<CleanMaterialCondition>lambdaQuery().eq(CleanMaterialCondition::getConditionGuid, conditionGuid));
                cleanMaterialConditionList.addAll(cleanMaterialConditions);
            }
            log.info("materialConditionList size : {}", cleanMaterialConditionList.size());

            //11 根据得到数据，在igt_task_condition_material新增数据，情形材料关系
            if(cleanMaterialConditionList.size() > 0) {
                insertConditionMaterial(cleanMaterialConditionList, vo);
            }

            //12 根据taskGuid查询clean_dn_task_general_fee_project  收费情况
            DbContextHolder.setDbType(DBTypeEnum.db2);
            List<CleanFeeProject> cleanFeeProjectList = cleanFeeProjectRepository.selectList(Wrappers.<CleanFeeProject>lambdaQuery()
                    .eq(CleanFeeProject::getTaskguid, taskGuid));
            log.info("feeList size : {}", cleanFeeProjectList.size());

            //13 根据得到数据，在igt_task_fee新增数据，事项收费情况
            insertFee(cleanFeeProjectList, vo);

            taskGuidList.add(taskGuid);
        }

        ExchangeTaskHandleItemResponse exchangeTaskHandleItemResponse = ExchangeTaskHandleItemResponse.builder()
                .taskGuidList(taskGuidList)
                .build();

        log.info("数据导入 end, {}", System.currentTimeMillis() - start);
        return exchangeTaskHandleItemResponse;
    }

    public void insertTaskBasic(CleanBasic cleanBasic, CleanExtend cleanExtend, CleanDirectory cleanDirectory, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

        IgtTaskBasic igtTaskBasic = IgtTaskBasic.builder()
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
                .productSourceType("01")
                .productType("01")
                .projectType(cleanBasic.getProjecttype())
                .promiseDay(cleanBasic.getPromiseday())
                .resultName(cleanExtend.getResultname())
                .resultType(cleanExtend.getResulttype())
                .resultSample(null)
                .serverType(cleanBasic.getServertype())
                .taskArea(null)
                .taskCode(cleanBasic.getTaskcode())
                .taskGuid(cleanExtend.getTaskguid())
                .taskHandleItem(cleanBasic.getTaskhandleitem())
                .taskName(cleanBasic.getTaskname())
                .taskState(cleanBasic.getTaskstate())
                .taskStatus("1")
                .taskType(cleanBasic.getTasktype())
                .taskVersion(cleanBasic.getTaskversion())
                .transactAddr(cleanBasic.getTransactaddr())
                .transactTime(cleanBasic.getTransacttime())
                .updateOrgId(vo.getUpdateOrgId())
                .updateTime(currentTime)
                .updateUserId(vo.getUpdateUserId())
                .useLevel(cleanBasic.getUselevel())
                .version(vo.getVersion())
                .build();
        igtBasicRepository.insert(igtTaskBasic);
    }

    public void insertTaskExtend(CleanBasic cleanBasic, CleanExtend cleanExtend, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

        IgtTaskExtend igtTaskExtend = IgtTaskExtend.builder()
                .id(cleanExtend.getId())
                .acceptCondition(cleanBasic.getAcceptcondition())
                .anticipateDay(cleanBasic.getAnticipateday())
                .anticipateExplain(cleanBasic.getAnticipateexplain())
                .anticipateType(cleanBasic.getAnticipatetype())
                .appIsSingleLogin(cleanBasic.getAppissinglelogin())
                .byLaw(cleanBasic.getBylaw())
                .bySuppose(null)
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
        igtExtendRepository.insert(igtTaskExtend);
    }

    public void insertMaterial(List<CleanMaterial> cleanMaterialList, CleanBasic cleanBasic, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

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
                    .isReused("0")
//                    .materialCategory()
                    .materialFormat(cleanMaterial.getMaterialformat())
                    .materialGuid(cleanMaterial.getRowguid())
//                    .materialKeyPoint()
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
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

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
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

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

    public void insertConditionMaterial(List<CleanMaterialCondition> cleanMaterialConditionList, ExchangeTaskHandleItemVo vo) {
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

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
