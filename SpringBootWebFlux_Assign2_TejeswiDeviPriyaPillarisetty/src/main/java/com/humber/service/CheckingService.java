package com.humber.service;

import com.humber.model.Checking;
import com.humber.repository.CheckingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CheckingService {

    @Autowired
    private CheckingRepository repo;

    public Mono<Checking> create(Checking c) {
        return repo.save(c);
    }

    public Flux<Checking> getAll() {
        return repo.findAll();
    }

    public Mono<Checking> update(String id, Checking c) {
        return repo.findById(id)
                .flatMap(existing -> {
                    existing.setBalance(c.getBalance());
                    existing.setAccountHolder(c.getAccountHolder());
                    return repo.save(existing);
                });
    }

    public Mono<Void> delete(String id) {
        return repo.deleteById(id);
    }
}