package mybatis.controller;

import mybatis.service.MyBatisService;
import mybatis.vo.entity.Person;
import mybatis.vo.entity.Player;
import mybatis.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/MyBatisController")
@Api(value = "MyBatisController", tags = {"MyBatis Controller"})
public class MyBatisController {

    @Autowired
    private MyBatisService service;

    @ApiOperation(value = "MyBatis测试", notes = "myBatisTest")
    @PostMapping(value = "/myBatisTest")
    public ResultBean<Player> myBatisTest() {
        Player player = service.MyBatisTest();
        return new ResultBean<>(player);
    }

    @ApiOperation(value = "MyBatis测试2", notes = "myBatisTest2")
    @GetMapping(value = "/myBatisTest2")
    public ResultBean<Person> myBatisTest2(@RequestParam Integer id) {
        Person person = service.MyBatisTest2(id);
        return new ResultBean<>(person);
    }
}
