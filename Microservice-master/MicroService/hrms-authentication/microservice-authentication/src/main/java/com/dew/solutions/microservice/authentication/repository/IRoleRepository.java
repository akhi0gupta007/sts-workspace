package com.dew.solutions.microservice.authentication.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.authentication.entity.Role;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

@Repository
public interface IRoleRepository extends IGenericRepository<Role, Long> {

	List<Role> findByRoleNameIn(List<String> roleNames);

}
