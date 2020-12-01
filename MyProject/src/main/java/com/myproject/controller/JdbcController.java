package com.myproject.controller;

import com.myproject.bean.Test;
import com.myproject.mapper.TestMapper;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jdbcController")
@Api(value = "jdbcController", tags = {"my jdbcController"})
public class JdbcController {

    @Autowired
    @Qualifier("jdbcTemplateOne")
    private JdbcTemplate jdbcTemplateOne;

    @ApiOperation(value = "myTest", notes = "myTest")
    @PostMapping(value = "/myTest")
    public ResultBean<Test> myTest(@RequestParam int id) {
        String SQL = "select * from task.test where id = ?";
        Test test = jdbcTemplateOne.queryForObject(SQL, new Object[]{id}, new TestMapper());

        return new ResultBean<Test>(test);
    }

    @ApiOperation(value = "myTest2", notes = "myTest2")
    @PostMapping(value = "/myTest2")
    public ResultBean<List<Test>> myTest2() {
        String SQL = "select * from task.test";
        List<Test> tests = jdbcTemplateOne.query(SQL, new TestMapper());

        return new ResultBean<>(tests);
    }
}
