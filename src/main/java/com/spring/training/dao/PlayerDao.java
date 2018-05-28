package com.spring.training.dao;

import com.spring.training.model.Player;

public interface PlayerDao {
    Player findById(Integer id);

    void savePlayer(Player player);
}
