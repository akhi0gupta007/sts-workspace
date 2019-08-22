package com.dew.solutions.microservices.professional.info.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.config.repository.IGenericRepository;
import com.dew.solutions.microservices.professional.info.entity.Category;

@Repository
public interface ICategoryRepository extends IGenericRepository<Category, Long> {

	Category findByCategoryName(String name);

}
