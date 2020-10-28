package com.myproject.jpa.repository;

import com.myproject.jpa.bean.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Player findPlayerByName(String name);

    boolean existsPlayersByName(String name);

    List<Player> findPlayerByGlory(String glory);

    @Query(value = "select * from player", nativeQuery = true)
    List<Player> findAllPlayer();

    @Query(value = "select * from player where name = ?", nativeQuery = true)
    Player findPlayerByQuery(String name);

    @Transactional
    @Modifying
    @Query(value = "update player set name = ?1 where name = ?2", nativeQuery = true)
    void updatePlayerName(String newName, String oldName);

    @Transactional
    @Modifying
    @Query(value = "insert into player(age, country, friend, glory, name, team)\n" +
            "values(?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void insertPlayerBySql(int age, String country, String friend, String glory, String name, String team);
}
