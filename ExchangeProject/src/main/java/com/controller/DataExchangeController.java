package com.controller;

import com.bean.response.ExchangeTaskHandleItemResponse;
import com.bean.result.ResultBean;
import com.bean.vo.ExchangeTaskHandleItemVo;
import com.service.IDataExchange;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@RequestMapping("/dataExchangeController")
@Api(value = "DataExchangeController", tags = {"data exchange controller"})
public class DataExchangeController {

    @Autowired
    IDataExchange iDataExchange;

    @ApiOperation(value = "数据处理", notes = "exchangeData")
    @PostMapping(value = "/exchangeData")
    public ResultBean<ExchangeTaskHandleItemResponse> exchangeData(@RequestBody ExchangeTaskHandleItemVo vo) {
        ExchangeTaskHandleItemResponse result = iDataExchange.doBusiness(vo);
        return new ResultBean<>(result);
    }

    @ApiOperation(value = "myTest", notes = "myTest")
    @PostMapping(value = "/myTest")
    public ResultBean<Boolean> myTest(@RequestBody ExchangeTaskHandleItemVo vo) {
        iDataExchange.myTest(vo);
        return new ResultBean<>(true);
    }

    @PostMapping(value = "/upload")
    public ResultBean<Boolean> update(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = transferFileName(file.getOriginalFilename());
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        InputStream fileStream = null;
        File tempFile = File.createTempFile("temp_" + fileName, suffixName);
        file.transferTo(tempFile);
        tempFile.deleteOnExit();
        fileStream = new FileInputStream(tempFile);

        InputStreamReader isr = new InputStreamReader(fileStream);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        while(s != null) {
            System.out.println(s);
            s = br.readLine();
        }

        return new ResultBean<>(true);
    }

    public static String transferFileName(String oldFileName) {
        if (StringUtils.isEmpty(oldFileName)) {
            return oldFileName;
        }
        oldFileName = oldFileName.trim();
        //判断是否为IE浏览器的文件名，IE浏览器下文件名会带有盘符信息
        // Check for Unix-style path
        int unixSep = oldFileName.lastIndexOf('/');
        // Check for Windows-style path
        int winSep = oldFileName.lastIndexOf('\\');
        // Cut off at latest possible point
        int pos = (winSep > unixSep ? winSep : unixSep);
        if (pos != -1) {
            // Any sort of path separator found...
            oldFileName = oldFileName.substring(pos + 1);
        }
        return oldFileName;
    }
}
