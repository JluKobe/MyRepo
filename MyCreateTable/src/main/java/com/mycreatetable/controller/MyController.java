package com.mycreatetable.controller;

import com.mycreatetable.jpa.ResultBean;
import com.mycreatetable.jpa.vo.UpTaskDirectoryVo;
import com.mycreatetable.service.IInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/controller")
@Api(value = "controller", tags = {"my controller"})
public class MyController {

    @Autowired
    private IInterface iInterface;

    @ApiOperation(value = "新增UpTaskDirectory", notes = "addUpTaskDirectory")
    @RequestMapping(value = {"/addUpTaskDirectory"}, method = RequestMethod.POST)
    public ResultBean<Boolean> addUpTaskDirectory(@RequestBody UpTaskDirectoryVo vo) {
        iInterface.addUpTaskDirectory(vo);
        return new ResultBean<>(true);
    }
}
