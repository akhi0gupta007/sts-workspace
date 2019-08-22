package com.dew.solutions.microservice.common.service;

import com.dew.solutions.microservice.common.entity.Nationality;
import com.dew.solutions.microservice.config.dto.NationalityDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface INationalityService extends IGenericService<NationalityDto, Long> {

	Nationality findByNationalityName(String name) throws ServiceException;

}
