package com.github.JoseAugusto1989.staties;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/staties")
public class StateResources {

    private final StateRepository repository;

    public StateResources(StateRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<State> staties() {
        return repository.findAll();
    }

}
