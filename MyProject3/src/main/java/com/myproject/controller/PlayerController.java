package com.myproject.controller;

import com.myproject.jpa.bean.Player;
import com.myproject.service.IPlayer;
import com.myproject.vo.PlayerVo;
import com.myproject.vo.result.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
@Api(value = "球员", tags = {"球员 controller"})
public class PlayerController {

    @Autowired
    private IPlayer iPlayer;

    @ApiOperation(value = "新增球员", notes = "insertPlayer")
//    @RequestMapping(value = {"/insertPlayer"}, method = RequestMethod.POST)
    @PostMapping(value = "/insertPlayer")
    public ResultBean<Long> insertPlayer(@RequestBody PlayerVo vo) {
        long id = iPlayer.addPlayer(vo);
        return new ResultBean<>(id);
    }

    @ApiOperation(value = "查询球员，通过id", notes = "getPlayerById")
    @RequestMapping(value = {"/getPlayerById"}, method = RequestMethod.GET)
    public ResultBean<Player> getPlayerById(@RequestParam long id) {
        Player p = iPlayer.getPlayerById(id);
        return new ResultBean<>(p);
    }

    @ApiOperation(value = "查询球员，通过name", notes = "getPlayerByName")
    @RequestMapping(value = {"/getPlayerByName"}, method = RequestMethod.GET)
    public ResultBean<Player> getPlayerByName(@RequestParam String name) {
        Player p = iPlayer.getPlayByName(name);
        return new ResultBean<>(p);
    }

    @ApiOperation(value = "修改球员age，通过name", notes = "updatePlayerAgeByName")
    @RequestMapping(value = {"/updatePlayerAgeByName"}, method = RequestMethod.GET)
    public ResultBean<Boolean> updatePlayerAgeByName(@RequestParam String name, @RequestParam int age) {
        boolean bool = iPlayer.updatePlayerAgeByName(name, age);
        return new ResultBean<>(bool);
    }

    @ApiOperation(value = "删除球员，通过name", notes = "deletePlayerByName")
    @RequestMapping(value = {"/deletePlayerByName"}, method = RequestMethod.GET)
    public ResultBean<Boolean> deletePlayerByName(@RequestParam String name) {
        boolean bool = iPlayer.deletePlayerByName(name);
        return new ResultBean<>(bool);
    }

    @ApiOperation(value = "修改球员friend，通过name", notes = "updatePlayerFriendByName")
    @RequestMapping(value = {"/updatePlayerFriendByName"}, method = RequestMethod.GET)
    public ResultBean<Boolean> updatePlayerFriendByName(@RequestParam String name, @RequestParam String friend) {
        boolean bool = iPlayer.updatePlayerFriendByName(name, friend);
        return new ResultBean<>(bool);
    }

    @ApiOperation(value = "修改球员glory，通过name", notes = "updatePlayerGloryByName")
    @RequestMapping(value = {"/updatePlayerGloryByName"}, method = RequestMethod.GET)
    public ResultBean<Boolean> updatePlayerGloryByName(@RequestParam String name, @RequestParam String glory) {
        boolean bool = iPlayer.updatePlayerGloryByName(name, glory);
        return new ResultBean<>(bool);
    }

    @ApiOperation(value = "查询球员数量", notes = "getCount")
    @RequestMapping(value = {"/getCount"}, method = RequestMethod.GET)
    public ResultBean<Long> getCount() {
        long count = iPlayer.getCount();
        return new ResultBean<>(count);
    }

    @ApiOperation(value = "查询所有球员", notes = "getAllPlayer")
    @RequestMapping(value = {"/getAllPlayer"}, method = RequestMethod.GET)
    public ResultBean<List<Player>> getAllPlayer() {
        List<Player> playerList = iPlayer.getAllPlayer();
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "判断球员是否存在", notes = "isExistByName")
    @RequestMapping(value = {"/isExistByName"}, method = RequestMethod.GET)
    public ResultBean<Boolean> isExistByName(@RequestParam String name) {
        boolean bool = iPlayer.isExistPlayer(name);
        return new ResultBean<>(bool);
    }

    @ApiOperation(value = "查询球员，通过glory", notes = "getPlayerByGlory")
    @RequestMapping(value = {"/getPlayerByGlory"}, method = RequestMethod.GET)
    public ResultBean<List<Player>> getPlayerByGlory(@RequestParam String glory) {
        List<Player> playerList = iPlayer.getPlayerListByGlory(glory);
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "查询所有球员，通过sql", notes = "getAllPlayerByQuery")
    @RequestMapping(value = {"/getAllPlayerByQuery"}, method = RequestMethod.GET)
    public ResultBean<List<Player>> getAllPlayerByQuery() {
        List<Player> playerList = iPlayer.getAllPlayerByQuery();
        return new ResultBean<>(playerList);
    }

    @ApiOperation(value = "查询球员，通过name sql", notes = "findPlayerByQuery")
    @RequestMapping(value = {"/findPlayerByQuery"}, method = RequestMethod.GET)
    public ResultBean<Player> findPlayerByQuery(@RequestParam String name) {
        return new ResultBean<>(iPlayer.findPlayerByQuery(name));
    }

    @ApiOperation(value = "修改球员名称，通过 sql", notes = "updatePlayerName")
    @RequestMapping(value = {"/updatePlayerName"}, method = RequestMethod.GET)
    public ResultBean<Long> updatePlayerName(@RequestParam String newName, @RequestParam String oldName) {
        return new ResultBean<>(iPlayer.updatePlayerName(newName, oldName));
    }

    @ApiOperation(value = "新增球员，通过sql", notes = "insertPlayerBySql")
    @RequestMapping(value = {"/insertPlayerBySql"}, method = RequestMethod.POST)
    public ResultBean<Long> insertPlayerBySql(@RequestBody PlayerVo vo) {
        long id = iPlayer.insertPlayerBySql(vo);
        return new ResultBean<>(id);
    }
}
