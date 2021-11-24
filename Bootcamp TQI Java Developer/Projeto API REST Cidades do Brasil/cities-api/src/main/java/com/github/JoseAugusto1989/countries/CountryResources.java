package com.github.JoseAugusto1989.countries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryResources {

    @Autowired
    private CountryRepository repository;

    // *** or create object
    /* public CountryResource(CountryRepository repository) {
           this.repository = repository;
       }
    */

    @GetMapping
    public List<Country> countries() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable long id) {
        Optional<Country> optional = Optional.of(repository.getById(id));

        if (optional.isPresent()) {
            return ResponseEntity.ok().body(optional.get());

        } else {
            return ResponseEntity.notFound().build();

        }

    }

}