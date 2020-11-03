package com.mycreatetable.service.impl;

import com.mycreatetable.jpa.bean.UpTaskDirectory;
import com.mycreatetable.jpa.repository.UpTaskDirectoryRepo;
import com.mycreatetable.jpa.vo.UpTaskDirectoryVo;
import com.mycreatetable.service.IInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfaceImpl implements IInterface {

    @Autowired
    private UpTaskDirectoryRepo upTaskDirectoryRepo;

    @Override
    public void addUpTaskDirectory(UpTaskDirectoryVo vo) {
        UpTaskDirectory upTaskDirectory = UpTaskDirectory.builder()
                .id(Long.valueOf(vo.getId()))
//                .version(vo.getVersion())
                .createTime(vo.getCreateTime())
                .createUserId(vo.getCreateUserId())
                .createOrgId(vo.getCreateOrgId())
                .tenantId(vo.getTenantId())
                .updateTime(vo.getUpdateTime())
                .updateUserId(vo.getUpdateUserId())
                .updateOrgId(vo.getUpdateOrgId())
                .rowGuid(vo.getRowGuid())
                .taskName(vo.getTaskName())
                .catalogCode(vo.getCatalogCode())
                .localCatalogCode(vo.getLocalCatalogCode())
                .taskType(vo.getTaskType())
                .byLaw(vo.getByLaw())
                .useLevel(vo.getUseLevel())
                .taskState(vo.getTaskState())
                .taskVersion(vo.getTaskVersion())
                .planEffectiveDate(vo.getPlanEffectiveDate())
                .planCancelDate(vo.getPlanCancelDate())
                .cdOperation(vo.getCdOperation())
                .cdTime(vo.getCdTime())
                .cdBatch(vo.getCdBatch())
                .dataSource(vo.getDataSource())
                .build();
         upTaskDirectoryRepo.save(upTaskDirectory);
    }
}
