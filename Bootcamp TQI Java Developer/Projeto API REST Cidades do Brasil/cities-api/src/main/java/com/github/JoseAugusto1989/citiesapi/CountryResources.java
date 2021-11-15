package com.github.JoseAugusto1989.citiesapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
