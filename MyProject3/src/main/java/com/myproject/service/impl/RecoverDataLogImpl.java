package com.myproject.service.impl;

import com.myproject.jpa.bean.RecoverDataLog;
import com.myproject.jpa.repository.RecoverRepository;
import com.myproject.service.IRecoverDataLog;
import com.myproject.vo.RecoverDataLogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecoverDataLogImpl implements IRecoverDataLog {

    @Autowired
    private RecoverRepository recoverRepository;

    @Override
    public RecoverDataLogVo getRecoverDataLogVo(long id) {
        Optional<RecoverDataLog> result = recoverRepository.findById(id);
        RecoverDataLog recoverDataLog = result.get();

        RecoverDataLogVo vo = RecoverDataLogVo.builder()
                .id(recoverDataLog.getId())
                .operateType(recoverDataLog.getOperateType())
                .log(recoverDataLog.getLog())
                .operateTime(recoverDataLog.getOperateTime())
                .error(recoverDataLog.getError())
                .build();

        return vo;
    }
}
