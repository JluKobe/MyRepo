package com.myproject.controller;

import com.myproject.jpa.bean.RecoverDataLog;
import com.myproject.service.IRecoverDataLog;
import com.myproject.vo.RecoverDataLogVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/local")
public class RecoverDataLogController {

    @Autowired
    private IRecoverDataLog recoverDataLog;

    @ApiOperation(value = "getData", notes = "getData")
    @RequestMapping(value = {"/getData"}, method = RequestMethod.POST)
    public ResultBean<RecoverDataLogVo> getRecoverDataLog(@RequestBody RecoverDataLog bean) {
        Long id = bean.getId();
        RecoverDataLogVo vo = recoverDataLog.getRecoverDataLogVo(id);
        ResultBean<RecoverDataLogVo> result = new ResultBean<>(vo);
        return result;
    }

    @ApiOperation(value = "getRecoverDataLog", notes = "getRecoverDataLog")
    @RequestMapping(value = {"/getRecoverDataLog"}, method = RequestMethod.GET)
    public ResultBean<RecoverDataLogVo> getRecoverDataLog2(@RequestParam Long id) {
        RecoverDataLogVo vo = recoverDataLog.getRecoverDataLogVo(id);
        ResultBean<RecoverDataLogVo> result = new ResultBean<>(vo);
        return result;
    }
}
