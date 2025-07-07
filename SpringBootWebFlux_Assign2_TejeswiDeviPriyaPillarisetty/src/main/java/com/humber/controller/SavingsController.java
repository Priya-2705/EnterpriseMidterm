package com.humber.controller;

import com.humber.model.Savings;
import com.humber.service.SavingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/savings")
public class SavingsController {

    @Autowired
    private SavingsService service;

    @PostMapping
    public Mono<Savings> create(@RequestBody Savings s) {
        return service.create(s);
    }

    @GetMapping
    public Flux<Savings> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Mono<Savings> update(@PathVariable String id, @RequestBody Savings s) {
        return service.update(id, s);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}