package com.humber.repository;

import com.humber.model.Savings;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsRepository extends ReactiveMongoRepository<Savings, String> {
}