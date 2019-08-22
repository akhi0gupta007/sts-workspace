package com.basic.application.commonservice.service.impl;

import org.dozer.Mapper;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.basic.application.commonservice.entity.City;
import com.basic.application.commonservice.repository.ICityRepository;
import com.basic.application.commonservice.service.ICityService;
import com.basic.application.config.dto.CityDto;
import com.basic.application.config.repository.IGenericRepository;
import com.basic.application.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CityServiceImpl extends AbstractGenericServiceImpl<CityDto, Long> implements ICityService {

	private ICityRepository iCityRepository;

	private Mapper mapper;

	@Autowired
	public CityServiceImpl(ICityRepository iCityRepository, Mapper mapper) {
		super((IGenericRepository) iCityRepository, mapper, CityDto.class, City.class);
		this.iCityRepository = iCityRepository;
		this.mapper = mapper;
	}

	@Override
	public CityDto findByCityName(String name) throws ServiceException {
		return this.mapper.map(iCityRepository.findByCityName(name), CityDto.class);
	}
}
