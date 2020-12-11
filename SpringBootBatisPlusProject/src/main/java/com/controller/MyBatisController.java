package com.controller;

import com.bean.ResultBean;
import com.bean.entity.Word;
import com.service.IWord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/MyBatisController")
@Api(value = "MyBatisController", tags = {"MyBatis Controller"})
public class MyBatisController {

    @Autowired
    private IWord iWord;

    @ApiOperation(value = "查询所有word", notes = "查询所有word")
    @PostMapping(value = "/findAllData")
    public ResultBean<List<Word>> findAllData() {
        List<Word> wordList = iWord.findAllData();
        return new ResultBean<>(wordList);
    }
}
