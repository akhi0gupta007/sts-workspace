package com.dew.solutions.microservice.common.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.common.entity.City;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface ICityRepository extends IGenericRepository<City, Long> {

	City findByCityName(String name);

}
