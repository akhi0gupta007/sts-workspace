package com.dew.solutions.microservice.common.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.common.entity.Designation;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface IDesignationRepository extends IGenericRepository<Designation, Long> {

	Designation findByDesignationName(String name);

}
