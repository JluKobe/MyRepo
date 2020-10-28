package com.myproject.controller;

import com.myproject.service.IStudent;
import com.myproject.vo.StudentVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@RestController
//@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudent student;

    @ApiOperation(value = "getStudent", notes = "getStudent")
    @RequestMapping(value = {"/getStudent"}, method = RequestMethod.GET)
    public ResultBean<StudentVo> getStudent(@RequestParam Long id) {
        StudentVo vo = student.getStudent(id);
        ResultBean bean = new ResultBean(vo);
        return bean;
    }

    @ApiOperation(value = "insertStudent", notes = "insertStudent")
    @RequestMapping(value = {"/insertStudent"}, method = RequestMethod.POST)
    public ResultBean<Boolean> insertStudent(@RequestBody StudentVo vo) {
        boolean bool = student.insertStudent(vo);
        return new ResultBean<>(bool);
    }
}
