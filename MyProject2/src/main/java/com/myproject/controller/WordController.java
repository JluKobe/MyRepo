package com.myproject.controller;

import com.myproject.service.IWord;
import com.myproject.vo.WordVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/word")
@Api(value = "word", tags = {"word controller"})
public class WordController {

    @Autowired
    IWord iWord;

    @ApiOperation(value = "新增单词", notes = "addWord")
    @RequestMapping(value = {"/addWord"}, method = RequestMethod.POST)
//    @PostMapping(value = "/addWord")
    public ResultBean<Long> addWord(@RequestBody WordVo vo) {
        long id = iWord.addWord(vo);
        return new ResultBean<>(id);
    }
}
