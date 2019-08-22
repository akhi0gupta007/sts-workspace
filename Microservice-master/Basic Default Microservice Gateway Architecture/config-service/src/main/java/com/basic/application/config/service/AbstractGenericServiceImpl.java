package com.basic.application.config.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolationException;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.transaction.annotation.Transactional;

import com.basic.application.config.constants.ApplicationConstants;
import com.basic.application.config.dto.SuperDto;
import com.basic.application.config.entity.SuperEntity;
import com.basic.application.config.repository.IGenericRepository;

public abstract class AbstractGenericServiceImpl<E extends SuperDto, K> implements IGenericService<E, K> {

	private IGenericRepository genericRepository;

	private Mapper mapper;

	private Class entityClazz;

	private Class dtoClazz;

	@Autowired
	public AbstractGenericServiceImpl(IGenericRepository iGenericDao, Mapper mapper, Class entityClazz,
			Class dtoClazz) {
		this.genericRepository = iGenericDao;
		this.mapper = mapper;
		this.entityClazz = entityClazz;
		this.dtoClazz = dtoClazz;
	}

	@Override
	@Transactional
	public E get(K id, String authToken) throws Throwable {
		try {
			return (E) this.mapper.map(this.genericRepository.findById(id).get(), dtoClazz);
		} catch (NoSuchElementException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public List<E> getAll(String authToken) throws Throwable {
		try {
			return this.genericRepository.findAll();
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public boolean remove(E dto, String authToken) throws Throwable {
		try {
			this.genericRepository.delete(this.mapper.map(dto, entityClazz));
			return true;
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public void saveAll(List<E> dtos, String authToken) throws Throwable {
		try {
			List<SuperEntity> entities = new ArrayList<>();
			for (SuperDto dto : dtos) {
				entities.add((SuperEntity) this.mapper.map(dto, entityClazz));
			}

			this.genericRepository.saveAll(entities);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	@Transactional
	public E saveOrUpdate(E dto, String authToken) throws Throwable {
		try {
			return (E) this.genericRepository.save(this.mapper.map(dto, entityClazz));
		} catch (DataAccessException e) {
			throw e;
		}
	}

	@Override
	public Exception determineRepoException(DataAccessException e) {
		if (e.getMostSpecificCause() instanceof ConstraintViolationException) {
			return e;
		} else if (e.getMostSpecificCause() instanceof DuplicateKeyException) {
			return e;
		} else if (e instanceof QueryTimeoutException) {
			return e;
		}
		return e;
	}
}
