package ioc.controller;

import io.swagger.annotations.ApiOperation;
import ioc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/myTest")
    @ApiOperation(value = "myTest")
    public void myTest() {
        accountService.saveAccount();
    }
}
