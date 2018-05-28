package com.spring.training.service;

import com.spring.training.dao.PlayerDao;
import com.spring.training.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerDao playerDao;

    @Override
    public Player findById(Integer id) {
        return playerDao.findById(id);
    }

    @Transactional
    @Override
    public void savePlayer(Player player) {
        playerDao.savePlayer(player);
    }
}
