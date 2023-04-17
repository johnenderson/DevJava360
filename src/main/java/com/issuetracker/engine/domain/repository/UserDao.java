package com.issuetracker.engine.dao;

import com.issuetracker.engine.domain.model.User;

import javax.persistence.EntityManager;

public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createUser(User user) {
        this.entityManager.persist(user);
    }

    public User readUser(final Integer cduser){
        return this.entityManager.find(User.class, cduser);
    }

    public void updateUser(final User user){
        this.entityManager.merge(user);
    }

    public void deleteUser(final User user){
        this.entityManager.remove(user);
    }


}