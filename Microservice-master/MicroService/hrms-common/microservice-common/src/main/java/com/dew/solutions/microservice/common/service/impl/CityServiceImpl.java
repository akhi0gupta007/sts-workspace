package com.dew.solutions.microservice.common.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.common.entity.City;
import com.dew.solutions.microservice.common.repository.ICityRepository;
import com.dew.solutions.microservice.common.service.ICityService;
import com.dew.solutions.microservice.config.dto.CityDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CityServiceImpl extends AbstractGenericServiceImpl<CityDto, Long> implements ICityService {

	private ICityRepository iCityRepository;

	private Mapper mapper;

	@Autowired
	public CityServiceImpl(ICityRepository iCityRepository, Mapper mapper) {
		super(iCityRepository, mapper, CityDto.class, City.class);
		this.iCityRepository = iCityRepository;
		this.mapper = mapper;
	}

	@Override
	public CityDto findByCityName(String name) throws ServiceException {
		return this.mapper.map(iCityRepository.findByCityName(name), CityDto.class);
	}
}
