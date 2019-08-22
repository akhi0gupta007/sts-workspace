package com.dew.solutions.microservices.professional.info.service.impl;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.config.dto.EmployeeSkillsDto;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;
import com.dew.solutions.microservices.professional.info.entity.EmployeeSkills;
import com.dew.solutions.microservices.professional.info.repository.IEmployeeSkillRepository;
import com.dew.solutions.microservices.professional.info.service.IEmployeeSkillService;

@Service
@Transactional(rollbackFor=Throwable.class)
public class EmployeeSkillServiceImpl extends AbstractGenericServiceImpl<EmployeeSkillsDto, Long>
		implements IEmployeeSkillService {

	private IEmployeeSkillRepository iEmployeeSkillRepository;

	private Mapper mapper;

	public EmployeeSkillServiceImpl(IEmployeeSkillRepository iEmployeeSkillRepository, Mapper mapper) {
		super(iEmployeeSkillRepository, mapper, EmployeeSkills.class, EmployeeSkillsDto.class);
		this.iEmployeeSkillRepository = iEmployeeSkillRepository;
		this.mapper = mapper;
	}

	@Override
	public EmployeeSkillsDto findByEmployeeId(Long employeeId) {
		return this.mapper.map(iEmployeeSkillRepository.findByEmployeeId(employeeId), EmployeeSkillsDto.class);
	}
}
