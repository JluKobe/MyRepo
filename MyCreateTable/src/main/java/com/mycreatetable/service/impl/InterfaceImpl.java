package com.mycreatetable.service.impl;

import com.mycreatetable.jpa.bean.UpTaskDirectory;
import com.mycreatetable.jpa.repository.UpTaskDirectoryRepo;
import com.mycreatetable.service.IInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfaceImpl implements IInterface {

    @Autowired
    private UpTaskDirectoryRepo upTaskDirectoryRepo;

    @Override
    public void addUpTaskDirectory(String cataLogCode, String rowGuid, String taskName) {
        UpTaskDirectory upTaskDirectory = UpTaskDirectory.builder()
                .catalogCode(cataLogCode)
                .rowGuid(rowGuid)
                .taskName(taskName)
                .build();
        upTaskDirectoryRepo.save(upTaskDirectory);
    }
}
