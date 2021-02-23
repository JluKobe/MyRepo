package com.controller;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.result.ResultBean;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.service.IDataExchange;
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

    @ApiOperation(value = "生产环境数据处理", notes = "exchangeData")
    @PostMapping(value = "/exchangeDataFormal")
    public ResultBean<ExchangeTaskHandleItemResponse> exchangeDataFormal(@RequestBody ExchangeTaskHandleItemVo vo) {
        ExchangeTaskHandleItemResponse result = iDataExchange.doBusinessProductionEnvironment(vo);
        return new ResultBean<>(result);
    }
}
