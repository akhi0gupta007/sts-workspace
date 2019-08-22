package com.dew.solutions.microservice.authentication.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.authentication.entity.AuthenticationEntity;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface IAuthenticationRepository extends IGenericRepository<AuthenticationEntity, Long> {

	AuthenticationEntity findByUsername(String username);

}
