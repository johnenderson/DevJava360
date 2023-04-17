package com.issuetracker.engine.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory ISSUETRACKER = Persistence.createEntityManagerFactory("IssueTracker");

    public static EntityManager getEntityManagerIssueTracker() {
        return ISSUETRACKER.createEntityManager();
    }
}
