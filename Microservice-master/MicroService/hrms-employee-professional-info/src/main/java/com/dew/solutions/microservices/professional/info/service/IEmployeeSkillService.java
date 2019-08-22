package com.dew.solutions.microservices.professional.info.service;

import com.dew.solutions.microservice.config.dto.EmployeeSkillsDto;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface IEmployeeSkillService extends IGenericService<EmployeeSkillsDto, Long> {

	public EmployeeSkillsDto findByEmployeeId(Long employeeId);

}
