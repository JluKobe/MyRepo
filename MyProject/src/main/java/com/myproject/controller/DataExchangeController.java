package com.myproject.controller;

import com.myproject.enums.ErrorCodeEnum;
import com.myproject.exception.BadResponseException;
import com.myproject.service.IDataExchange;
import com.myproject.vo.exchange.ExchangeTaskHandleItemVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataExchangeController")
@Api(value = "DataExchangeController", tags = {"data exchange controller"})
public class DataExchangeController {

    @Autowired
    IDataExchange iDataExchange;

    @ApiOperation(value = "业务处理", notes = "getBusiness")
    @PostMapping(value = "/getBusiness")
    public ResultBean<Boolean> getBusiness(@RequestBody ExchangeTaskHandleItemVo vo) {
        List<String> taskHandleItemList = vo.getTaskHandleItemList();
        iDataExchange.doBusiness(taskHandleItemList);
        return new ResultBean<>(true);
    }
}
