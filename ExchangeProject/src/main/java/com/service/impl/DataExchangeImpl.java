package com.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.bean.entity.clean.*;
import com.bean.response.ExchangeTaskHandleItemResponse;
import com.config.DbContextHolder;
import com.enums.DBTypeEnum;
import com.repository.*;
import com.service.IDataExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ExchangeTaskHandleItemResponse doBusiness(List<String> taskHandleItemList, String isHighFrequency) {
        //使用db2
        DbContextHolder.setDbType(DBTypeEnum.db2);
        CleanFeeProject cleanFeeProject = cleanFeeProjectRepository.selectById(7859);

        CleanExtend cleanExtend = cleanExtendRepository.selectById(8047);

        CleanBasic cleanBasic = cleanBasicRepository.selectById(89566);

        CleanMaterial cleanMaterial = cleanMaterialRepository.selectById(33359);

        CleanItemCondition cleanItemCondition = cleanItemConditionRepository.selectById(701);

        CleanDirectory cleanDirectory = cleanDirectoryRepository.selectById(26);

        List<CleanFeeProject> cleanFeeProjectList = cleanFeeProjectRepository.selectList(Wrappers.<CleanFeeProject>lambdaQuery());
        System.out.println(cleanFeeProjectList.size());
        return null;
    }
}
