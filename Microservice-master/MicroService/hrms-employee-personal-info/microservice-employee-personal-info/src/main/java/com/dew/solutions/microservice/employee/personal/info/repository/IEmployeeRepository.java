package com.dew.solutions.microservice.employee.personal.info.repository;

import org.springframework.stereotype.Repository;

import com.dew.solutions.microservice.config.repository.IGenericRepository;
import com.dew.solutions.microservice.employee.personal.info.entity.EmployeePersonalInfo;

@Repository
public interface IEmployeeRepository extends IGenericRepository<EmployeePersonalInfo,Long>{

}
