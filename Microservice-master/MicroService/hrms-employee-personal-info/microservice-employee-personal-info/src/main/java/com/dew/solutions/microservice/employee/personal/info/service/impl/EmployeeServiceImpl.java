package com.dew.solutions.microservice.employee.personal.info.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.config.dto.EmployeePersonalInfoDto;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;
import com.dew.solutions.microservice.employee.personal.info.entity.EmployeePersonalInfo;
import com.dew.solutions.microservice.employee.personal.info.repository.IEmployeeRepository;
import com.dew.solutions.microservice.employee.personal.info.service.IEmployeeService;

@Service
@Transactional(rollbackFor = Throwable.class)
public class EmployeeServiceImpl extends AbstractGenericServiceImpl<EmployeePersonalInfoDto, Long>
		implements IEmployeeService {

	private Mapper mapper;

	@Autowired
	public EmployeeServiceImpl(IEmployeeRepository employeeRepository, Mapper mapper) {
		super(employeeRepository, mapper, EmployeePersonalInfoDto.class, EmployeePersonalInfo.class);
		this.mapper = mapper;
	}

}
