package com.dew.solutions.microservice.common.service.impl;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dew.solutions.microservice.common.entity.Country;
import com.dew.solutions.microservice.common.repository.ICountryRepository;
import com.dew.solutions.microservice.common.service.ICountryService;
import com.dew.solutions.microservice.config.dto.CountryDto;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.service.AbstractGenericServiceImpl;

@Service
@Transactional(rollbackFor = Throwable.class)
public class CountryServiceImpl extends AbstractGenericServiceImpl<CountryDto, Long> implements ICountryService {

	private ICountryRepository iCountryRepository;

	private Mapper mapper;

	@Autowired
	public CountryServiceImpl(ICountryRepository iCountryRepository, Mapper mapper) {
		super(iCountryRepository, mapper, CountryDto.class, Country.class);
		this.iCountryRepository = iCountryRepository;
		this.mapper = mapper;
	}

	@Override
	public CountryDto findByCountryName(String name) throws ServiceException {
		return this.mapper.map(iCountryRepository.findByCountryName(name), CountryDto.class);
	}
}
