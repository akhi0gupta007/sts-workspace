package com.dew.solutions.microservice.config.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.dew.solutions.microservice.config.dto.SuperDto;
import com.dew.solutions.microservice.config.exception.GenericDatabaseException;
import com.dew.solutions.microservice.config.exception.ServiceException;

public interface IGenericService<E extends SuperDto, K> {

	E get(K id, String authToken) throws ServiceException;

	List<E> getAll(String authToken) throws ServiceException;

	boolean remove(E entity, String authToken) throws ServiceException;

	void saveAll(List<E> entities, String authToken) throws ServiceException;

	E saveOrUpdate(E entity, String authToken) throws ServiceException;

	GenericDatabaseException determineRepoException(DataAccessException e);
}