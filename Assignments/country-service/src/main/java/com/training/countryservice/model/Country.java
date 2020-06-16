package com.training.countryservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Country {
    // name, CODE AS countrycode, continent, region, population
    // SELECT NAME, CODE AS COUNTRYCODE, CONTINENT, REGION, POPULATION FROM country where Code='IND';
    private String name;
    private String countrycode;
    private String continent;
    private String region;
    private Long population;

}
