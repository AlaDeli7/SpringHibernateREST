package com.spring.training.dao;

import com.spring.training.model.Player;

import java.util.List;

public interface PlayerDao {
    Player findById(Integer id);
    List<Player> findAllPlayer();
    void savePlayer(Player player);
    void deletePlayer(Integer id);
}
