package com.myproject.service;

import com.myproject.jpa.bean.Player;
import com.myproject.vo.PlayerVo;

import java.util.List;

public interface IPlayer {
    long addPlayer(PlayerVo vo);

    Player getPlayerById(long id);

    Player getPlayByName(String name);

    boolean updatePlayerAgeByName(String name, int age);

    boolean deletePlayerByName(String name);

    boolean updatePlayerFriendByName(String name, String friend);

    boolean updatePlayerGloryByName(String name, String glory);

    long getCount();

    List<Player> getAllPlayer();

    boolean isExistPlayer(String name);

    List<Player> getPlayerListByGlory(String glory);

    List<Player> getAllPlayerByQuery();

    Player findPlayerByQuery(String name);

    long updatePlayerName(String newName, String oldName);

    long insertPlayerBySql(PlayerVo player);
}
