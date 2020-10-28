package com.myproject.controller;

import com.myproject.service.ISam;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sam")
@Api(value = "sam算法", tags = {"sam"})
public class SamController {

    @Autowired
    private ISam iSam;

    @ApiOperation(value = "计算sam", notes = "countSam")
    @RequestMapping(value = {"/countSam"}, method = RequestMethod.GET)
    public ResultBean<double[]> countSam(@RequestParam String localUrl, @RequestParam String writeUrl) {
        double[] samResult = null;

        try {
            samResult = iSam.countSam(localUrl, writeUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResultBean<>(samResult);
    }
}
