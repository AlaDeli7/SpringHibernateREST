package com.spring.training.dao;

import com.spring.training.model.Player;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Player findById(Integer id) {
        return (Player) sessionFactory.getCurrentSession().get(Player.class,id);
    }

    @Override
    public List<Player> findAllPlayer() {
        return sessionFactory.getCurrentSession().createCriteria(Player.class).list();
    }

    @Override
    public void savePlayer(Player player) {
        sessionFactory.getCurrentSession().save(player);
    }

    @Override
    public void deletePlayer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Player player = (Player) session.get(Player.class,id);
        session.delete(player);
    }
}
