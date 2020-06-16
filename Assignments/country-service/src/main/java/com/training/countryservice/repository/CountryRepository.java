package com.training.countryservice.repository;

import com.training.countryservice.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class CountryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Country getCountryByCode(String countryCode) {
        String query = "SELECT  name, CODE AS countrycode, continent, region, population FROM country where Code= ? ";
        return jdbcTemplate.queryForObject(query, new CountryRowMapper(), countryCode);
    }

    static class CountryRowMapper implements RowMapper<Country> {

        @Override
        public Country mapRow(ResultSet resultSet, int i) throws SQLException {
            Country country = new Country();
            country.setName(resultSet.getString("name"));
            country.setCountrycode(resultSet.getString("countrycode"));
            country.setContinent(resultSet.getString("continent"));
            country.setRegion(resultSet.getString("region"));
            country.setPopulation(resultSet.getLong("population"));
            return country;
        }
    }
}
