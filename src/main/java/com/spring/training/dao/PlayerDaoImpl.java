package com.spring.training.dao;

import com.spring.training.model.Player;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player findById(Integer id) {
        return (Player) sessionFactory.getCurrentSession().get(Player.class,id);
    }

    @Override
    public void savePlayer(Player player) {
        sessionFactory.getCurrentSession().save(player);
    }
}
