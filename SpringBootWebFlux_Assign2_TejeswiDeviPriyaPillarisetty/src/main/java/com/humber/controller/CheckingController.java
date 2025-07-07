package com.humber.controller;

import com.humber.model.Checking;
import com.humber.service.CheckingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/checking")
public class CheckingController {

    @Autowired
    private CheckingService service;

    @PostMapping
    public Mono<Checking> create(@RequestBody Checking c) {
        return service.create(c);
    }

    @GetMapping
    public Flux<Checking> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public Mono<Checking> update(@PathVariable String id, @RequestBody Checking c) {
        return service.update(id, c);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return service.delete(id);
    }
}