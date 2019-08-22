package com.basic.application.commonservice.repository;

import org.springframework.stereotype.Repository;

import com.basic.application.commonservice.entity.City;
import com.basic.application.config.repository.IGenericRepository;

@Repository
public interface ICityRepository extends IGenericRepository<City, Long> {

	City findByCityName(String name);

}
