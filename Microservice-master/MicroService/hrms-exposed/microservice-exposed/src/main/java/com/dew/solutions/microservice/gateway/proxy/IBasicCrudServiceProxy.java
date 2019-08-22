package com.dew.solutions.microservice.gateway.proxy;

import org.springframework.http.ResponseEntity;

import com.dew.solutions.microservice.config.exception.ServiceException;

//TODO change to DTO Parent
public interface IBasicCrudServiceProxy {

	ResponseEntity<?> getById(String token, String entity, Long id) throws ServiceException;

	ResponseEntity<?> getAll(String token, String entity) throws ServiceException;

	ResponseEntity<?> removeById(String token, String entity, Long id) throws ServiceException;

	ResponseEntity<?> saveOrUpdate(String token, String entity, Object t) throws ServiceException;

}
