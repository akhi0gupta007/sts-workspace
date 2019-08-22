package com.dew.solutions.microservice.common.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.common.entity.State;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface IStateRepository extends IGenericRepository<State, Long> {

}
