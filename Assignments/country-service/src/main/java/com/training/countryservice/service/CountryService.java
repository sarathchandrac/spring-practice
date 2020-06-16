package com.training.countryservice.service;

import com.training.countryservice.model.Country;
import com.training.countryservice.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;
    public Country getCountryByCode(String countryCode) {
        if(null == countryCode || countryCode.trim().equals(""))
            throw new IllegalArgumentException("Country code should not be empty or null");
        return countryRepository.getCountryByCode(countryCode);
    }
}
