package com.controller;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.result.ResultBean;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.service.IDataExchange;
import com.service.IDateExchangeNew;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dataExchangeController")
@Api(value = "DataExchangeController", tags = {"data exchange controller"})
public class DataExchangeController {

    @Autowired
    IDataExchange iDataExchange;

    @Autowired
    IDateExchangeNew iDateExchangeNew;

    @ApiOperation(value = "准生产数据处理，新表结构", notes = "exchangeData")
    @PostMapping(value = "/exchangeData")
    public ResultBean<ExchangeTaskHandleItemResponse> exchangeData(@RequestBody ExchangeTaskHandleItemVo vo) {
        ExchangeTaskHandleItemResponse result = iDataExchange.doBusiness(vo);
        return new ResultBean<>(result);
    }

    @ApiOperation(value = "准生产数据处理，新表结构", notes = "exchangeDataNew")
    @PostMapping(value = "/exchangeDataNew")
    public ResultBean<ExchangeTaskHandleItemResponse> exchangeDataNew(@RequestBody ExchangeTaskHandleItemVo vo) {
        ExchangeTaskHandleItemResponse result = iDateExchangeNew.doBusiness(vo);
        return new ResultBean<>(result);
    }
}
