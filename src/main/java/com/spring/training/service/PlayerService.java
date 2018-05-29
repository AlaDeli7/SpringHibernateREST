package com.spring.training.service;

import com.spring.training.model.Player;

import java.util.List;

public interface PlayerService {
    Player findById(Integer id);
    List<Player> findAllPlayers();
    void savePlayer(Player player);
    void deletePlayer(Integer id);
}
