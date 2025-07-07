package com.humber.repository;

import com.humber.model.Checking;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends ReactiveMongoRepository<Checking, String> {
}