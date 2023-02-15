package com.issuetracker.engine.dao;

import com.issuetracker.engine.model.Issue;
import jakarta.persistence.EntityManager;

public class IssueDao {

    private final EntityManager entityManager;

    public IssueDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void createIssue(final Issue issue) {
        this.entityManager.persist(issue);
    }

    public Issue readIssue(final String idprocess){
        return this.entityManager.find(Issue.class, idprocess);
    }

    public void updateIssue(final Issue issue){
        this.entityManager.merge(issue);
    }

    public void deleteIssue(final Issue issue){
        this.entityManager.remove(issue);
    }

}
