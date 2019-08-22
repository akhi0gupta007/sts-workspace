package com.dew.solutions.microservice.common.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.common.entity.Country;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface ICountryRepository extends IGenericRepository<Country, Long> {

	Country findByCountryName(String name);

}
