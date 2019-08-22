package com.dew.solutions.microservice.common.service;

import com.dew.solutions.microservice.config.dto.CountryDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.IGenericService;

public interface ICountryService extends IGenericService<CountryDto, Long> {

	CountryDto findByCountryName(String name) throws ServiceException;

}
