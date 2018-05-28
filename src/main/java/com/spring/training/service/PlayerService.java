package com.spring.training.service;

import com.spring.training.model.Player;

public interface PlayerService {
    Player findById(Integer id);
    void savePlayer(Player player);
}
