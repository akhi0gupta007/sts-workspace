package com.dew.solutions.microservices.professional.info.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.config.repository.IGenericRepository;
import com.dew.solutions.microservices.professional.info.entity.EmployeeSkills;

@Repository
public interface IEmployeeSkillRepository extends IGenericRepository<EmployeeSkills, Long> {

	EmployeeSkills findByEmployeeId(Long employeeId);

}
