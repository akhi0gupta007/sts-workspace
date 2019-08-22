package com.dew.solutions.microservice.config.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dew.solutions.microservice.config.database.config.BaseDaoConfig;
import com.dew.solutions.microservice.config.database.config.DatabaseQueryConfig;

public abstract class AbstractGenericDaoImpl<T> implements IGenericDao<T> {

	protected BaseDaoConfig baseDaoConfig;

	DatabaseQueryConfig queryBuilder = null;

	JdbcTemplate template;

	private AbstractGenericDaoImpl() {
	}

	public AbstractGenericDaoImpl(BaseDaoConfig baseDaoConfig) {
		this.baseDaoConfig = baseDaoConfig;
		queryBuilder = new DatabaseQueryConfig(baseDaoConfig);
	}

	@Override
	public Boolean create(T t) {
		try {
			template.update(queryBuilder.getInsertQuery(), new Object[] { baseDaoConfig.getParams() });
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Boolean update(T t) {
		try {
			template.update(queryBuilder.getUpdateQuery(), new Object[] { baseDaoConfig.getParams() });
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean delete(T t) {
		try {
			template.update(queryBuilder.getUpdateQuery(), new Object[] { baseDaoConfig.getParams() });
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean deleteById(Long id) {
		try {
			template.update(queryBuilder.getDeleteQuery(), new Object[] { baseDaoConfig.getParams() });
			return true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<T> getAll() {
		try {
			return ((List<T>) template.queryForList(queryBuilder.getSelectAllQuery(),
					new BeanPropertyRowMapper(baseDaoConfig.getClazz())));
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public T getById(Long id) {
		try {
			return ((T) template.queryForObject(queryBuilder.getSelectAllQuery(),
					new BeanPropertyRowMapper(baseDaoConfig.getClazz())));
		} catch (DataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
