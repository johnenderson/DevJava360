package com.issuetracker.engine.domain.repository;

import com.issuetracker.engine.domain.model.entity.UserEntity;

import javax.persistence.EntityManager;

public class UserDao {

    private final EntityManager entityManager;

    public UserDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createUser(UserEntity user) {
        this.entityManager.persist(user);
    }

    public UserEntity readUser(final Integer cduser){
        return this.entityManager.find(UserEntity.class, cduser);
    }

    public void updateUser(final UserEntity user){
        this.entityManager.merge(user);
    }

    public void deleteUser(final UserEntity user){
        this.entityManager.remove(user);
    }


}