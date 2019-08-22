package com.dew.solutions.microservices.professional.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.config.controller.GenericCrudController;
import com.dew.solutions.microservice.config.dto.EmployeeSkillsDto;
import com.dew.solutions.microservices.professional.info.service.IEmployeeSkillService;

@RestController
@RequestMapping(path = "/professional")
public class EmployeeProfessionalController extends GenericCrudController<EmployeeSkillsDto, IEmployeeSkillService> {

	private IEmployeeSkillService iEmployeeSkillService;

	@Autowired
	public EmployeeProfessionalController(IEmployeeSkillService service) {
		super(service);
		this.iEmployeeSkillService = service;
	}

}
