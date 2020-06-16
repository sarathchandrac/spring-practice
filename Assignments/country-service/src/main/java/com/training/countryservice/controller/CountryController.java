package com.training.countryservice.controller;

import com.training.countryservice.model.Country;
import com.training.countryservice.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @Autowired
    private CountryService countryService;
    @GetMapping("/country/{country-code}")
    public Country getCountryByCode(@PathVariable("country-code") String countryCode){
        return countryService.getCountryByCode(countryCode);
    }
}
