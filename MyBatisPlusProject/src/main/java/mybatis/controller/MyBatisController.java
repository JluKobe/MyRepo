package mybatis.controller;

import mybatis.service.MyBatisService;
import mybatis.vo.PlayerVo;
import mybatis.vo.entity.Person;
import mybatis.vo.entity.Player;
import mybatis.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/MyBatisController")
@Api(value = "MyBatisController", tags = {"MyBatis Controller"})
public class MyBatisController {

    @Autowired
    private MyBatisService service;

    @ApiOperation(value = "查询player 通过wrapper id", notes = "查询player 通过wrapper id")
    @PostMapping(value = "/queryByIdUseWrappers")
    public ResultBean<Player> queryByIdUseWrappers(@RequestBody PlayerVo vo) {
        Player player = service.queryByIdUseWrappers(vo.getId());
        return new ResultBean<>(player);
    }

    @ApiOperation(value = "查询person 通过wrapper", notes = "查询person 通过wrapper")
    @GetMapping(value = "/queryByIdUseXml")
    public ResultBean<Person> queryByIdUseXml(@RequestParam Integer id) {
        Person person = service.queryByIdUseXml(id);
        return new ResultBean<>(person);
    }

    @ApiOperation(value = "查询player 通过wrapper id name", notes = "查询player 通过wrapper id name")
    @GetMapping(value = "/queryByIdAndNameUseWrappers")
    public ResultBean<Player> queryByIdAndNameUseWrappers(@RequestParam Integer id, @RequestParam String name) {
        Player player = service.queryByIdAndNameUseWrappers(id, name);
        return new ResultBean<>(player);
    }

    @ApiOperation(value = "查询player AllData", notes = "查询player AllData")
    @GetMapping(value = "/queryAllData")
    public ResultBean<List<Player>> queryAllData() {
        List<Player> playerList = service.queryAllData();
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "查询player name模糊查询", notes = "查询player name模糊查询")
    @GetMapping(value = "/queryLikeName")
    public ResultBean<List<Player>> queryLikeName(String name) {
        List<Player> playerList = service.queryLikeName(name);
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "查询player name left模糊查询", notes = "查询player name left模糊查询")
    @GetMapping(value = "/queryLikeLeftName")
    public ResultBean<List<Player>> queryLikeLeftName(String name) {
        List<Player> playerList = service.queryLikeLeftName(name);
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "查询person", notes = "查询person")
    @GetMapping(value = "/queryPerson")
    public ResultBean<Person> queryByEx(Integer id) {
        Person person = service.queryByEx(id);
        return new ResultBean<>(person);
    }
}
