package com.basic.application.config.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.basic.application.config.dto.SuperDto;

public interface IGenericService<E extends SuperDto, K> {

	E get(K id, String authToken) throws Throwable;

	List<E> getAll(String authToken) throws Throwable;

	boolean remove(E entity, String authToken) throws Throwable;

	void saveAll(List<E> entities, String authToken) throws Throwable;

	E saveOrUpdate(E entity, String authToken) throws Throwable;

	Exception determineRepoException(DataAccessException e);
}