package com.dew.solutions.microservices.professional.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dew.solutions.microservice.config.controller.GenericCrudController;
import com.dew.solutions.microservice.config.dto.SkillDto;
import com.dew.solutions.microservices.professional.info.service.ISkillService;

@RestController
@RequestMapping(path = "skill")
public class SkillController extends GenericCrudController<SkillDto, ISkillService> {

	private ISkillService iSkillService;

	@Autowired
	public SkillController(ISkillService service) {
		super(service);
		this.iSkillService = service;
	}

}
