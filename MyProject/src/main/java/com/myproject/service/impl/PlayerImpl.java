package com.myproject.service.impl;

import com.myproject.jpa.bean.Player;
import com.myproject.jpa.repository.PlayerRepository;
import com.myproject.service.IPlayer;
import com.myproject.vo.PlayerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerImpl implements IPlayer {

    @Autowired
    private PlayerRepository repository;

    @Override
    public long addPlayer(PlayerVo vo) {
        Player p = Player.builder()
                .age(vo.getAge())
                .friend(vo.getFriend())
                .country(vo.getCountry())
                .glory(vo.getGlory())
                .name(vo.getName())
                .team(vo.getTeam())
                .build();
        repository.save(p);
        Player newPlayer = repository.findPlayerByName(vo.getName());
        return newPlayer.getId();
    }

    @Override
    public Player getPlayerById(long id) {
        Optional<Player> optionalPlayer = repository.findById(id);
        Player p = optionalPlayer.get();
        return p;
    }

    @Override
    public Player getPlayByName(String name) {
        Player p = repository.findPlayerByName(name);
        return p;
    }

    @Override
    public boolean updatePlayerAgeByName(String name, int age) {
        Player p = repository.findPlayerByName(name);
        p.setAge(age);
        repository.save(p);
        return true;
    }

    @Override
    public boolean deletePlayerByName(String name) {
        Player p = repository.findPlayerByName(name);
        repository.delete(p);
        return true;
    }

    @Override
    public boolean updatePlayerFriendByName(String name, String friend) {
        Player p = repository.findPlayerByName(name);
        p.setFriend(friend);
        repository.save(p);
        return true;
    }

    @Override
    public boolean updatePlayerGloryByName(String name, String glory) {
        Player p = repository.findPlayerByName(name);
        p.setGlory(glory);
        repository.save(p);
        return true;
    }

    @Override
    public long getCount() {
        long count = repository.count();
        return count;
    }

    @Override
    public List<Player> getAllPlayer() {
        List<Player> list = repository.findAll();
        return list;
    }

    @Override
    public boolean isExistPlayer(String name) {
        boolean bool = repository.existsPlayersByName(name);
        return bool;
    }

    @Override
    public List<Player> getPlayerListByGlory(String glory) {
        List<Player> playerList = repository.findPlayerByGlory(glory);
        return playerList;
    }

    @Override
    public List<Player> getAllPlayerByQuery() {
        List<Player> playerList = repository.findAllPlayer();
        return playerList;
    }

    @Override
    public Player findPlayerByQuery(String name) {
        Player player = repository.findPlayerByQuery(name);
        return player;
    }

    @Override
    public long updatePlayerName(String newName, String oldName) {
        repository.updatePlayerName(newName, oldName);
        Player player = repository.findPlayerByName(newName);
        return player.getId();
    }

    @Override
    public long insertPlayerBySql(PlayerVo player) {
        repository.insertPlayerBySql(player.getAge(), player.getCountry(), player.getFriend(), player.getGlory(), player.getName(), player.getTeam());
        Player p = repository.findPlayerByName(player.getName());
        return p.getId();
    }
}
