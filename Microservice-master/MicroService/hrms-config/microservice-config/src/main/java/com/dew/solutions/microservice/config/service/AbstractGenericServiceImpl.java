package com.dew.solutions.microservice.config.service;

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

import com.dew.solutions.microservice.config.constants.ApplicationConstants;
import com.dew.solutions.microservice.config.constants.ApplicationConstants.ApplicationErrorCode;
import com.dew.solutions.microservice.config.dto.SuperDto;
import com.dew.solutions.microservice.config.entity.SuperEntity;
import com.dew.solutions.microservice.config.exception.GenericDatabaseException;
import com.dew.solutions.microservice.config.exception.ServiceException;
import com.dew.solutions.microservice.config.repository.IGenericRepository;

public abstract class AbstractGenericServiceImpl<E extends SuperDto, K> implements IGenericService<E, K> {

	private IGenericRepository genericRepository;

	private Mapper mapper;

	private Class entityClazz;

	private Class dtoClazz;

	private AbstractGenericServiceImpl() {

	}

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
	public E get(K id, String authToken) throws ServiceException {
		try {
			return (E) this.mapper.map(this.genericRepository.findById(id).get(), dtoClazz);
		} catch (NoSuchElementException e) {
			throw new GenericDatabaseException(ApplicationConstants.ApplicationErrorCode.DATABASE_ENTITY_DOES_NOT_EXIST,
					e);
		}
	}

	@Override
	@Transactional
	public List<E> getAll(String authToken) throws ServiceException {
		try {
			return this.genericRepository.findAll();
		} catch (DataAccessException e) {
			throw new GenericDatabaseException(ApplicationConstants.ApplicationErrorCode.DATABASE_ERROR, e);
		}
	}

	@Override
	@Transactional
	public boolean remove(E dto, String authToken) throws ServiceException {
		try {
			this.genericRepository.delete(this.mapper.map(dto, entityClazz));
			return true;
		} catch (DataAccessException e) {
			throw new GenericDatabaseException(ApplicationConstants.ApplicationErrorCode.DATABASE_ERROR, e);
		}
	}

	@Override
	@Transactional
	public void saveAll(List<E> dtos, String authToken) throws ServiceException {
		try {
			List<SuperEntity> entities = new ArrayList<>();
			for (SuperDto dto : dtos) {
				entities.add((SuperEntity) this.mapper.map(dto, entityClazz));
			}

			this.genericRepository.saveAll(entities);
		} catch (DataAccessException e) {
			throw new GenericDatabaseException(ApplicationConstants.ApplicationErrorCode.DATABASE_ERROR, e);
		}
	}

	@Override
	@Transactional
	public E saveOrUpdate(E dto, String authToken) throws ServiceException {
		try {
			return (E) this.genericRepository.save(this.mapper.map(dto, entityClazz));
		} catch (DataAccessException e) {
			throw new GenericDatabaseException(ApplicationConstants.ApplicationErrorCode.DATABASE_ERROR, e);
		}
	}

	@Override
	public GenericDatabaseException determineRepoException(DataAccessException e) {
		if (e.getMostSpecificCause() instanceof ConstraintViolationException) {
			return new GenericDatabaseException(ApplicationErrorCode.DATABASE_CONSTRAINT_CONFLICT,
					e.getMostSpecificCause());
		} else if (e.getMostSpecificCause() instanceof DuplicateKeyException) {
			return new GenericDatabaseException(ApplicationErrorCode.DATABASE_DUPLICATE_KEY, e.getMostSpecificCause());
		} else if (e instanceof QueryTimeoutException) {
			return new GenericDatabaseException(ApplicationErrorCode.DATABASE_TIMEOUT, e.getMostSpecificCause());
		}
		return new GenericDatabaseException(ApplicationErrorCode.DATABASE_ERROR, e.getMostSpecificCause());
	}
}
