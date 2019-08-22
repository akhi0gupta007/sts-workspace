package com.dew.solutions.microservice.config.dao;

import java.util.List;

public interface IGenericDao<T> {

	public Boolean create(T t);

	public Boolean update(T t);

	public Boolean delete(T t);

	public Boolean deleteById(Long id);

	public List<T> getAll();

	public T getById(Long id);
}
