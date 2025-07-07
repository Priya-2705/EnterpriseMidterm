package com.humber.service;

import com.humber.model.Savings;
import com.humber.repository.SavingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SavingsService {

    @Autowired
    private SavingsRepository repo;

    public Mono<Savings> create(Savings s) {
        return repo.save(s);
    }

    public Flux<Savings> getAll() {
        return repo.findAll();
    }

    public Mono<Savings> update(String id, Savings s) {
        return repo.findById(id)
                .flatMap(existing -> {
                    existing.setBalance(s.getBalance());
                    existing.setAccountHolder(s.getAccountHolder());
                    return repo.save(existing);
                });
    }

    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
}