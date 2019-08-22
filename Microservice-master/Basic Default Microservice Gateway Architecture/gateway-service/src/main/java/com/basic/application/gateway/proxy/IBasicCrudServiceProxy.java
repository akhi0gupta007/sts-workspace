package com.basic.application.gateway.proxy;

import org.springframework.http.ResponseEntity;

//TODO change to DTO Parent
public interface IBasicCrudServiceProxy {

	ResponseEntity<?> getById(String token, String entity, Long id) throws Throwable;

	ResponseEntity<?> getAll(String token, String entity) throws Throwable;

	ResponseEntity<?> removeById(String token, String entity, Long id) throws Throwable;

	ResponseEntity<?> saveOrUpdate(String token, String entity, Object t) throws Throwable;

}