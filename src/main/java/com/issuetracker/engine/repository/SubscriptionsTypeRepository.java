package com.issuetracker.engine.repository;

import com.issuetracker.engine.model.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionsTypeRepository extends JpaRepository<SubscriptionType, Long> {
}
