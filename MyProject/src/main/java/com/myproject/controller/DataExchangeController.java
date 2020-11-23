package com.myproject.controller;

import com.myproject.jpa.bean.Word;
import com.myproject.service.IDataExchange;
import com.myproject.service.IWord;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataExchangeController")
@Api(value = "DataExchangeController", tags = {"data exchange controller"})
public class DataExchangeController {

    @Autowired
    IDataExchange iDataExchange;

    @ApiOperation(value = "查询测试", notes = "getTest")
    @GetMapping(value = "/getTest")
    public ResultBean<Boolean> getTest() {
        iDataExchange.test();
        return new ResultBean<>(true);
    }
}
