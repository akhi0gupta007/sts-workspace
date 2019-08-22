package com.basic.application.commonservice.service;

import org.hibernate.service.spi.ServiceException;

import com.basic.application.config.dto.CityDto;
import com.basic.application.config.service.IGenericService;

public interface ICityService extends IGenericService<CityDto, Long> {

	CityDto findByCityName(String name) throws ServiceException;

}
