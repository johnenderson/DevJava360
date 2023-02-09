package com.issuetracker.engine.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory ISSUETRACKER = Persistence.createEntityManagerFactory("IssueTracker");

    public static EntityManager getEntityManagerIssueTracker() {
        return ISSUETRACKER.createEntityManager();
    }
}
