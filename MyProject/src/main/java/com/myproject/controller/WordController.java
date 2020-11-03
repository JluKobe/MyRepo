package com.myproject.controller;

import com.myproject.jpa.bean.Word;
import com.myproject.service.IWord;
import com.myproject.vo.WordVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @ApiOperation(value = "查询所有单词", notes = "getAllWord")
    @GetMapping(value = "/getAllWord")
    public ResultBean<List<Word>> getAllWord() {
        List<Word> wordList = iWord.getAllWord();
        return new ResultBean<>(wordList);
    }

    @ApiOperation(value = "查询所有句子", notes = "getAllSentence")
    @GetMapping(value = "/getAllSentence")
    public ResultBean<List<String>> getAllSentence() {
        List<String> sentenceList = iWord.getAllSentence();
        return new ResultBean<>(sentenceList);
    }

    @ApiOperation(value = "查询所有词意", notes = "getAllMean")
    @GetMapping(value = "/getAllMean")
    public ResultBean<List<String>> getAllMean() {
        List<String> meansList = iWord.getAllMean();
        return new ResultBean<>(meansList);
    }
}
