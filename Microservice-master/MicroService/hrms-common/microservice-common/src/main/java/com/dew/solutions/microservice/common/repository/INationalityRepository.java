package com.dew.solutions.microservice.common.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.common.entity.Nationality;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface INationalityRepository extends IGenericRepository<Nationality, Long> {

	Nationality findByNationalityName(String name);

}
