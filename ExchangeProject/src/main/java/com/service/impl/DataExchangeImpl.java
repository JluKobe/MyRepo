package com.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.*;
import com.bean.entity.igt.IgtTaskBasic;
import com.bean.entity.igt.IgtTaskExtend;
import com.bean.entity.igt.IgtTaskFee;
import com.bean.response.ExchangeTaskHandleItemResponse;
import com.config.DbContextHolder;
import com.enums.DBTypeEnum;
import com.repository.*;
import com.service.IDataExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private IgtBasicRepository igtBasicRepository;

    @Autowired
    private IgtExtendRepository igtExtendRepository;

    @Autowired
    private IgtFeeRepository igtFeeRepository;

    @Override
    public ExchangeTaskHandleItemResponse doBusiness(List<String> taskHandleItemList, String isHighFrequency) {
        log.info("数据导入 start，taskHandleItemList size : {}, 是否高频事项 : {}", taskHandleItemList.size(), isHighFrequency);
        long start = System.currentTimeMillis();

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
            insertTaskBasic(cleanBasic, cleanExtend, isHighFrequency, cleanDirectory);

            //5 根据得到数据，在igt_task_extend新增数据，扩展信息
            insertTaskExtend(cleanBasic, cleanExtend);

            //6 根据task_guid查询clean_dn_task_general_material

            //7 根据得到数据，在igt_task_material_catalog新增数据，事项材料目录信息

            //8 根据taskGuid查询clean_dn_audit_item_condition

            //9 根据得到数据，在igt_task_condition新增数据，事项情形

            //10 根据condition_guid查询clean_dn_audit_material_condition

            //11 根据得到数据，在igt_task_condition_material新增数据，情形材料关系

            //12 根据taskGuid查询clean_dn_task_general_fee_project  收费情况

            //13 根据得到数据，在igt_task_fee新增数据，事项收费情况
        }

//        CleanFeeProject cleanFeeProject = cleanFeeProjectRepository.selectById(7859);
//
//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String currentTime = sdf.format(date);
//
//
//        IgtTaskFee igtTaskFee = IgtTaskFee.builder()
//                .id(cleanFeeProject.getId())
//                .descExplain(cleanFeeProject.getDescexplain())
//                .feeName(cleanFeeProject.getFeename())
//                .feeStand(cleanFeeProject.getFeestand())
//                .isDesc(cleanFeeProject.getIsdesc())
//                .taskGuid(cleanFeeProject.getTaskguid())
//                .version("1")
//                .createOrgId("1")
//                .updateOrgId("1")
//                .createUserId("1")
//                .updateUserId("1")
//                .createTime(currentTime)
//                .updateTime(currentTime)
//                .build();
//
//        DbContextHolder.setDbType(DBTypeEnum.db1);
//        igtFeeRepository.insert(igtTaskFee);

//        CleanExtend cleanExtend = cleanExtendRepository.selectById(8047);
//
//        CleanBasic cleanBasic = cleanBasicRepository.selectById(89566);
//
//        CleanMaterial cleanMaterial = cleanMaterialRepository.selectById(33359);
//
//        CleanItemCondition cleanItemCondition = cleanItemConditionRepository.selectById(701);
//
//        CleanDirectory cleanDirectory = cleanDirectoryRepository.selectById(26);
//
//        List<CleanFeeProject> cleanFeeProjectList = cleanFeeProjectRepository.selectList(Wrappers.<CleanFeeProject>lambdaQuery());
//        System.out.println(cleanFeeProjectList.size());
        return null;
    }

    public void insertTaskBasic(CleanBasic cleanBasic, CleanExtend cleanExtend, String isHighFrequency, CleanDirectory cleanDirectory) {
        DbContextHolder.setDbType(DBTypeEnum.db1);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(date);

        IgtTaskBasic igtTaskBasic = IgtTaskBasic.builder()
                .id(cleanBasic.getId())
                .catalogCode(cleanBasic.getCatalogcode())
                .catalogName(cleanDirectory.getTaskname())
                .createOrgId("1")
                .createTime(currentTime)
                .createUserId("1")
                .deptCode(cleanBasic.getDeptcode())
                .deptName(cleanBasic.getDeptname())
                .deptType(cleanBasic.getDepttype())
                .handleType(cleanBasic.getHandletype())
                .isBatch("0")
                .isEntryCenter(cleanExtend.getIsentrycenter())
                .isExpress(cleanExtend.getIsexpress())
                .isHighFrequency(isHighFrequency)
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
                .updateOrgId("1")
                .updateTime(currentTime)
                .updateUserId("1")
                .useLevel(cleanBasic.getUselevel())
                .version("1")
                .build();
        igtBasicRepository.insert(igtTaskBasic);
    }

    public void insertTaskExtend(CleanBasic cleanBasic, CleanExtend cleanExtend) {
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
                .createOrgId("1")
                .createTime(currentTime)
                .createUserId("1")
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
                .updateOrgId("1")
                .updateTime(currentTime)
                .updateUserId("1")
                .version("1")
                .build();
        igtExtendRepository.insert(igtTaskExtend);
    }
}
