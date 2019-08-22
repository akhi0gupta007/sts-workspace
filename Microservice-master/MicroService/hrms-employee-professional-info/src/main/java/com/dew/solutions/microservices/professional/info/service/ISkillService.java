package com.dew.solutions.microservices.professional.info.service;

import com.dew.solutions.microservice.config.dto.SkillDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface ISkillService extends IGenericService<SkillDto, Long> {

	SkillDto findBySkillName(String name) throws ServiceException;
}
