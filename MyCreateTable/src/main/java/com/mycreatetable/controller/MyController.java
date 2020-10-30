package com.mycreatetable.controller;

import com.mycreatetable.jpa.ResultBean;
import com.mycreatetable.service.IInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controller")
@Api(value = "controller", tags = {"my controller"})
public class MyController {

    @Autowired
    private IInterface iInterface;

    @ApiOperation(value = "新增UpTaskDirectory", notes = "addUpTaskDirectory")
    @RequestMapping(value = {"/addUpTaskDirectory"}, method = RequestMethod.GET)
    public ResultBean<Boolean> addUpTaskDirectory(@RequestParam String rowGuid, @RequestParam String taskName, @RequestParam String cataLogCode) {
        iInterface.addUpTaskDirectory(cataLogCode, rowGuid, taskName);
        return new ResultBean<>(true);
    }
}
