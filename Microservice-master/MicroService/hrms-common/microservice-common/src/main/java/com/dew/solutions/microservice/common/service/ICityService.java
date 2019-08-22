package com.dew.solutions.microservice.common.service;

import com.dew.solutions.microservice.config.dto.CityDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface ICityService extends IGenericService<CityDto, Long> {

	CityDto findByCityName(String name) throws ServiceException;

}
